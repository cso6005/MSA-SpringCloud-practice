package com.example.stockservice.controller;

import com.example.stockservice.vo.ResponseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {


//    @Value("${test.data}")
//    private String data;

    @Autowired
    private Environment env;

    @GetMapping("/test")
    public String test() {
        return "테스트 성공";
    }

    @GetMapping("/config-test")
    public String testConfigClient() {
        return "stock config 테스트 성공 : " + env.getProperty("test.data");
    }


    // feignClient 관련 테스트
    @GetMapping("/{itemId}/item")
    public ResponseEntity<ResponseItem> getItem(@PathVariable("itemId") String itemId) {

        ResponseItem responseItem = new ResponseItem("1", "아이폰", 10);


        return ResponseEntity.status(HttpStatus.OK).body(responseItem);
    }

}
