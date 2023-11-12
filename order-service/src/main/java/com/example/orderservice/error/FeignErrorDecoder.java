package com.example.orderservice.error;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        switch(response.status()){
            case 400:
                break;
            case 404:
                if(methodKey.contains("getItem")) {
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()),
                            "stock_service.exception.item_is_empty");
                }
                break;
            default:
                return new Exception(response.reason());
        }

        // 예외없이 정상이면 null 반환
        return null;
    }
}
