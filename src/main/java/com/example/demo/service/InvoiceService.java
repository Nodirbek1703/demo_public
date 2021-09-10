package com.example.demo.service;

import com.example.demo.entity.Invoice;
import com.example.demo.service.impl.InvoiceServiceImpl;

import java.util.List;

public interface InvoiceService {

    List<Invoice> expiredInvoices();
    List<Invoice> overPaidInvoices();
}
