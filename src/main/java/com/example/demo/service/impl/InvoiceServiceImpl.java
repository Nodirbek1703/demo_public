package com.example.demo.service.impl;

import com.example.demo.entity.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    final
    InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public List<Invoice> expiredInvoices() {
        return invoiceRepository.findAllByIssuedDateAfterDueDate();
    }

    @Override
    public List<Invoice> wrongDateInvoices() {
        return null;
    }

    @Override
    public List<Invoice> overPaidInvoices() {
        return null;
    }
}
