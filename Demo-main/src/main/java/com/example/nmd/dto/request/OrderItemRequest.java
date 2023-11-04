package com.example.nmd.dto.request;

import lombok.Data;

@Data
public class OrderItemRequest {
    private long product_id;
    private int quantity ;
}
