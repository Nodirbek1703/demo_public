package com.example.demo.service;

import com.example.demo.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> expiredInvoices();
    List<Invoice> wrongDateInvoices();
    List<Invoice> overPaidInvoices();
    Invoice getInvoice(Integer id);
}
