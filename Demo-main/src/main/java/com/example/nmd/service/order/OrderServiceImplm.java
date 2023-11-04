package com.example.nmd.service.order;

import com.example.nmd.dto.entity.OrderItemDTO;
import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.dto.request.OrderItemRequest;
import com.example.nmd.model.Order;
import com.example.nmd.model.OrderItem;
import com.example.nmd.model.Product;
import com.example.nmd.repository.OrderItemRepository;
import com.example.nmd.repository.OrderRepository;
import com.example.nmd.repository.ProductRepository;
import com.example.nmd.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class OrderServiceImplm implements Orderservice {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        List<OrderItem> orderItems = new ArrayList<>() ;
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
            OrderItem orderItem = OrderItem.builder().quantity(item.getQuantity())
                            .order(order).build();
            orderItems.add(orderItem);
            order.setQuantity(order.getQuantity() + item.getQuantity());
            Product product = productRepository.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Không tìm thấy id sản phẩm"));
            totalValue += item.getQuantity() * product.getPrice();
        }
        order.setTotalValueOrder(totalValue);
        orderRepository.save(order);
        orderItemRepository.saveAll(orderItems);

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
    public ResponseEntity<?> getById(Long id) {
       Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("không tìm thấy id"));

      return  ResponseEntity.ok(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order deleteOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()){
            throw  new RuntimeException("Không tồn tại id bạn vừa tìm");
        }
        orderRepository.delete(order.get());
        return   order.get();
    }

  public ResponseEntity<?> getOrderItemByOrderId (Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay id"));
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for(OrderItem orderItem : order.getOrderItems()){
            Product product = productRepository.findById(orderItem.getId()).orElseThrow(() -> new RuntimeException("không tìm thấy id sản phẩm"));

            OrderItemDTO orderItemDTO =  OrderItemDTO.builder().product(product).quantity(orderItem.getQuantity()).build();

            orderItemDTOS.add(orderItemDTO);
        }
        return ResponseEntity.ok().body( orderItemDTOS);
    }
}
