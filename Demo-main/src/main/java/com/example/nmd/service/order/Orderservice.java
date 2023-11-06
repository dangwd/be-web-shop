package com.example.nmd.service.order;

import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Orderservice {
    Order createOrder(CreateOrderRequest createOrderRequest);
    Order updateOrder(CreateOrderRequest createOrderRequest);

    ResponseEntity<?> getById(String id);

    List<Order> getAllOrder();

    Order deleteOrderById(String id);


ResponseEntity<?> getOrderItemByOrderId (String id);
 }
