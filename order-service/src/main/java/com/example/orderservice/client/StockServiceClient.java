package com.example.orderservice.client;

import com.example.orderservice.vo.ResponseItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service", url = "http://localhost:8002")
public interface StockServiceClient {

    @GetMapping("/{itemId}/item")
    ResponseItem getItem(@PathVariable("itemId") String itemId);

}

