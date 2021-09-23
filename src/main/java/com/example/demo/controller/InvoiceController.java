package com.example.demo.controller;


import com.example.demo.dto.InvoiceAmountDTO;
import com.example.demo.dto.InvoiceDTO;
import com.example.demo.entity.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class InvoiceController {

    final
    InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/expired_invoices")
    public List<Invoice> getExpiredInvoices(){
        return invoiceService.expiredInvoices();
    }

    @GetMapping("/expired_invoices")
    public List<InvoiceDTO> getWrongDateInvoices(){
        return invoiceService.wrongDateInvoices();
    }


    @GetMapping("/overpaid_invoices")
    public List<InvoiceAmountDTO> getOverPaidInvoices()
    {
        return invoiceService.overPaidInvoices();
    }




}
