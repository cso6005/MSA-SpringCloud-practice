package com.example.orderservice.service;

import com.example.orderservice.client.StockServiceClient;
import com.example.orderservice.vo.ResponseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private StockServiceClient stockServiceClient;

    public ResponseItem getItem(String itemId) {
        System.out.println("서비스 -------------------------------------" + itemId);

        ResponseItem item = stockServiceClient.getItem(itemId);

        System.out.println("----------------------들고온 데이터 " + item);
        return item;
    }
}
