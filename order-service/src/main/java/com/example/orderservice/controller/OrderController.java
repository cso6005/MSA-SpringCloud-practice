package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Value("${test.data}")
    private String data;

    @GetMapping("/test")
    public String test() {
        return "테스트 성공";
    }

    @GetMapping("/config-test")
    public String testConfigClient() {
        return "order config 테스트 성공 : " + data;
    }

}
