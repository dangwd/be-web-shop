package com.example.nmd.controller;

import com.example.nmd.dto.request.CreateOrderRequest;
import com.example.nmd.dto.request.FilterOrderRequest;
import com.example.nmd.dto.response.BaseResponse;
import com.example.nmd.service.order.Orderservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderController {
    private final Orderservice orderservice ;
    @PostMapping("create")
    public BaseResponse createOrder(@RequestBody CreateOrderRequest request){
        return BaseResponse.successData(orderservice.createOrder(request));
    }
  @PostMapping("update")
    public BaseResponse updateOrder(@RequestBody CreateOrderRequest request){
        return BaseResponse.successData(orderservice.updateOrder(request));
    }

    @GetMapping("/{id}")
    public BaseResponse getOrderById(@PathVariable String id){
        return BaseResponse.successData(orderservice.getById(id));
    }
    @GetMapping("/order-item/{id}")
    public BaseResponse getOrderItemByOrderId(@PathVariable String id){
        return BaseResponse.successData(orderservice.getOrderItemByOrderId(id));
    }

    @GetMapping("all")
    public BaseResponse getAllOrder(){
        return BaseResponse.successListData(orderservice.getAllOrder() , orderservice.getAllOrder().size());
    }

    @DeleteMapping("del/{id}")
    public BaseResponse deleteOrder(@PathVariable String id){
        return
                BaseResponse.successData(orderservice.deleteOrderById(id));
    }

    @PostMapping("filter")
    public ResponseEntity<?> filterByCondition (@RequestBody FilterOrderRequest request){
        return orderservice.filterOrderByCondition(request);
    }



}
