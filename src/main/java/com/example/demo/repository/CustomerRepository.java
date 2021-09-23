package com.example.demo.repository;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByOrdersIsNull();

    @Query(value = "select c.id ,c.name,o.id from Customer  inner join Order o on c.id = o.customerId order by  o.id desc  ")
    List<CustomerDTO> findAllByLastOrders();
}
