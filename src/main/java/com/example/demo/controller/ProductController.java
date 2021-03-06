package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    final
    ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> getProductList() {
        return productService.getProducts();
    }

    @GetMapping("/details")
    public Product getProductById(
            @RequestParam("product_id") Integer productId
    ) {
        return productService.getProduct(productId);
    }


    @GetMapping("/high-demand-products")
    public List<ProductDTO> getHighDemandProductById() {
        return productService.highDemandProducts();
    }

}
