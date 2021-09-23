package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> customersWithOutOrders();
    List<CustomerDTO> customersLastOrders();
}
