package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    final
    CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/list")
    public List<Category> getCategoryList() {
        return categoryService.getListOfCategories();
    }


    @GetMapping("/")
    public Category getCategoryList(
            @RequestParam("product_id") Integer productId
    ) {
        return categoryService.getCategoryByProductId(productId);
    }
}
