package com.example.nmd.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class FilterOrderRequest {
    private String email;
    private String name;
    private String phoneNumber;
    private Date orderCreationDate;
    private String addr;

}
