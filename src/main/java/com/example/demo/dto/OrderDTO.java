package com.example.demo.dto;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class OrderDTO {
    private Integer orderId;
    private Customer customer;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderDate;
    private String productName;

    public static OrderDTO fromEntity(Order order, ProductService productService){
    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setOrderId(order.getId());
    orderDTO.setCustomer(order.getCustomer());
    orderDTO.setOrderDate(order.getOrderDate());
        if (productService.getByOrderId(order.getId()) != null) {
            orderDTO.setProductName(productService.getByOrderId(order.getId()).getName());
        }
        return orderDTO;
    }
}
