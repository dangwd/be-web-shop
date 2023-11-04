package com.example.nmd.repository;

import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {

}
