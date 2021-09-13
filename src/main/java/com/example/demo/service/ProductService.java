package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> highDemandProducts();
    List<Product> bulkProducts();
    Product getProduct(Integer id);
    List<Product> getProducts();
    Product getByOrderId(Integer orderId);
}
