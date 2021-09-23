package com.example.demo.service;

import com.example.demo.dto.InvoiceAmountDTO;
import com.example.demo.dto.InvoiceDTO;
import com.example.demo.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> expiredInvoices();
    List<InvoiceDTO> wrongDateInvoices();
    List<InvoiceAmountDTO> overPaidInvoices();
    Invoice getInvoice(Integer id);
}
