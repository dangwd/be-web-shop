package com.example.nmd.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateProductRequest {

    private String image;
    private long id ;
    private String productName;
    private String description;
    private String type;
    private Date createTime;
    private float price;
    private long quantityInStore = 0;
}
