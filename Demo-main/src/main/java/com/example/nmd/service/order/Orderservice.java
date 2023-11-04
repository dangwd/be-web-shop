package com.example.nmd.service.order;

import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Orderservice {
    Order createOrder(CreateOrderRequest createOrderRequest);
    Order updateOrder(CreateOrderRequest createOrderRequest);

    Order getById(long id);

    List<Order> getAllOrder();

    Order deleteOrderById(long id);
}
