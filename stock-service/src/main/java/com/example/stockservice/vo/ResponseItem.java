package com.example.stockservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseItem {

    private String itemId;
    private String itemName;
    private int quantity;

}
