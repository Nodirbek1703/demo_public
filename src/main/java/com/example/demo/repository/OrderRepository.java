package com.example.demo.repository;

import com.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order getById(Integer id);
    @Query("select o from Order o inner join Details d on o.id = d.orderId where o.orderDate>?1 and d.productId=null")
    Order findAllByOrderDate(Date orderDate);
}
