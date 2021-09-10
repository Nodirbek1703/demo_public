package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    final
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> highDemandProducts() {
        return null;
    }

    @Override
    public List<Product> bulkProducts() {
        return null;
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.getOne(id);
    }
}
