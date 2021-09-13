package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Order;
import com.example.demo.request.OrderRequest;

import java.util.HashMap;

public interface OrderService {

    ResponseDTO createOrder(OrderRequest request);

    OrderDTO getOrder(Integer orderId);

    Order getOne(Integer id);
}
