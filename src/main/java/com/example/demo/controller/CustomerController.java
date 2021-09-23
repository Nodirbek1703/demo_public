package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CustomerController {

    final
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers_without_orders")
    public List<Customer> getCustomerWithoutOrders()  {
        return customerService.customersWithOutOrders();
    }

    @GetMapping("/customers_last_orders")
    public List<CustomerDTO> getCustomerLastOrders()  {
        return customerService.customersLastOrders();
    }
}
