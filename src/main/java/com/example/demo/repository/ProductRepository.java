package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("Select p from Product p join Details d on p.id = d.productId join Order o on d.orderId =?1")
    Product getProductByOrderId(Integer id);

    @Query("Select p from Product p join Details d on p.id =d.productId where sum(d.quantity)>10")
    List<Product> getQuantity();
}
