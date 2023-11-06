package com.example.nmd.dto.request;

import lombok.Data;

@Data
public class OrderItemRequest {
    private String productId;
    private int quantity ;
}
