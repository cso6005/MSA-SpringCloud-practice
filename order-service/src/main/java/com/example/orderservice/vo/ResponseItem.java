package com.example.orderservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseItem {

    private String itemId;
    private String itemName;
    private int quantity;

}
