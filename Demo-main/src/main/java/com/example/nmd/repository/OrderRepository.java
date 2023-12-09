package com.example.nmd.repository;

import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order , String> {
    List<Order> findAll(Specification<Order> specification);

}
