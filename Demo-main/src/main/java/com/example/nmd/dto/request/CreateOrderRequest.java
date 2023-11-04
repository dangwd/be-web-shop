package com.example.nmd.dto.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateOrderRequest {



    private String addr;
    private long id ;

    private String email;

    private String phoneNumber;

    private Float totalValueOrder = 0.0f;

    private Date orderCreationDate;

    private String status;

    private String name;
    List<OrderItemRequest> listOrderItemReq ;


}
