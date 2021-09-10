package com.example.demo.service.impl;

import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public List<Invoice> expiredInvoices() {
        return null;
    }
}
