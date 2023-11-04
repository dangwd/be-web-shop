package com.example.nmd.service.order;

import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.dto.request.OrderItemRequest;
import com.example.nmd.model.Order;
import com.example.nmd.model.Product;
import com.example.nmd.repository.OrderRepository;
import com.example.nmd.repository.ProductRepository;
import com.example.nmd.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OrderServiceImplm implements Orderservice {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Override
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        float totalValue = 0.f;
        Order order = Order.builder()
                .email(createOrderRequest.getEmail())
                .name(createOrderRequest.getName())
                .orderCreationDate(new Date())
                .addr(createOrderRequest.getAddr())
                .phoneNumber(createOrderRequest.getPhoneNumber())
                .orderCreationDate(new Date())
                .status(createOrderRequest.getStatus()).build();

        for (OrderItemRequest item : createOrderRequest.getListOrderItemReq()) {
            order.setQuantity(order.getQuantity() + item.getQuantity());
            Product product = productService.getProductById(item.getProductId());
            totalValue += item.getQuantity() * product.getPrice();
        }
        order.setTotalValueOrder(totalValue);
        orderRepository.save(order);

        return order;
    }

    @Override
    public Order updateOrder(CreateOrderRequest createOrderRequest) {
        Optional<Order> order = orderRepository.findById(createOrderRequest.getId());
        if(!order.isPresent()){
            throw  new RuntimeException("Không tồn tại id bạn vừa tìm");
        }
        order.get().setStatus(createOrderRequest.getStatus());
        orderRepository.save(order.get());
        return order.get();
    }

    @Override
    public Order getById(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()){
            throw  new RuntimeException("Không tồn tại id bạn vừa tìm");
        }
      return   orderRepository.save(order.get());
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order deleteOrderById(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()){
            throw  new RuntimeException("Không tồn tại id bạn vừa tìm");
        }
        orderRepository.delete(order.get());
        return   order.get();
    }
}
