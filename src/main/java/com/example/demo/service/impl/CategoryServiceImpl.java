package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository categoryRepository;
    final ProductService productService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }


    @Override
    public List<Category> getListOfCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByProductId(Integer productId) {
        Category category;
        Product product = productService.getProduct(productId);
        if(product == null){
            return null;
        }else{
            category = product.getCategory();
        }
        return category;
    }
}
