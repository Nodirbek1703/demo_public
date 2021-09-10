package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> customersWithOutOrders() {
        return null;
    }
}
