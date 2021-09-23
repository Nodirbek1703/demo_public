package com.example.demo.repository;

import com.example.demo.dto.InvoiceDTO;
import com.example.demo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findAllByDueDateAfterAndIssuedDateIsNull(Date nowDate);
    @Query("select i.id,i.issuedDate,i.orderId, o.orderDate from Invoice i join Order o  on o.id = i.orderId  where i.issuedDate>i.dueDate")
    List<InvoiceDTO> findAllByIssuedDateAfterDueDate();
}
