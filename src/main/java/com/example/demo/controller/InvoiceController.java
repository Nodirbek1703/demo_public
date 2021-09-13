package com.example.demo.controller;


import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceController {

    final
    InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }




}
