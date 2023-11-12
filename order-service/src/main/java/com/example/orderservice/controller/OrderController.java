package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.ResponseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @Autowired private Environment env;

  // config 관련 테스트
  @GetMapping("/config-test")
  public String testConfigClient() {
    return "order config 테스트 성공 : " + env.getProperty("test.data");
  }

  // feignClient 관련 테스트
  @GetMapping("/getItemInfo/{itemId}")
  public ResponseEntity<ResponseItem> getItemInfo(@PathVariable("itemId") String itemId) {

    ResponseItem responseItem = orderService.getItem("1");
    return ResponseEntity.status(HttpStatus.OK).body(responseItem);
  }
}
