package com.example.demo.service.impl;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.DetailsRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    final
    ProductRepository productRepository;
    final DetailsRepository detailsRepository;

    public ProductServiceImpl(ProductRepository productRepository, DetailsRepository detailsRepository) {
        this.productRepository = productRepository;
        this.detailsRepository = detailsRepository;
    }


    @Override
    public List<ProductDTO> highDemandProducts() {
       List<Product> products =  productRepository.getQuantity();
       ProductDTO productDTO = new ProductDTO();
       List<ProductDTO> productDTOS = new LinkedList<ProductDTO>();
       for(Product product : products) {
           productDTO.setId(product.getId());
           productDTO.setTotalNumber(detailsRepository.getQuantityByProductId(product.getId()));
        productDTOS.add(productDTO);
       }

       return  productDTOS;
    }

    @Override
    public List<Product> bulkProducts() {
        return null;
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getByOrderId(Integer orderId) {
        return productRepository.getProductByOrderId(orderId);
    }
}
