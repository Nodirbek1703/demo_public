package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Order;
import com.example.demo.request.OrderRequest;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/order")
public class OrderController {

    final
    OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public ResponseDTO createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
    @GetMapping("/details")
    public OrderDTO getOrderDetails(
            @RequestParam("order_id") Integer orderId
    ) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/orders_without_details")
    public Order getOrderWithoutDetails() throws ParseException {
        return orderService.getOrderWithoutDetails();
    }



}
