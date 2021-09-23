package com.example.demo.repository;

import com.example.demo.entity.Order;
import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select sum(p.amount) from Payment p where p.invoice_id = ?1")
    Double getAmount(Integer InvoiceId);

}
