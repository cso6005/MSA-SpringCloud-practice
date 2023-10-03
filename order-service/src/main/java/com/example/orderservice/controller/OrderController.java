package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.ResponseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @Value("${test.data}")
    private String data;

    // config 관련 테스트
    @GetMapping("/config-test")
    public String testConfigClient() {
        return "order config 테스트 성공 : " + data;
    }

    // feignClient 관련 테스트
    @GetMapping("/getItemInfo/{itemId}")
    public ResponseEntity<ResponseItem> getItemInfo(@PathVariable("itemId") String itemId) {

        System.out.println(itemId);

        ResponseItem responseItem = orderService.getItem("1");
        return ResponseEntity.status(HttpStatus.OK).body(responseItem);
    }

}
