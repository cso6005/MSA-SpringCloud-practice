package com.example.orderservice.service;

import com.example.orderservice.client.StockServiceClient;
import com.example.orderservice.vo.ResponseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final StockServiceClient stockServiceClient;

    public ResponseItem getItem(String itemId) {
        return stockServiceClient.getItem(itemId);
    }
}
