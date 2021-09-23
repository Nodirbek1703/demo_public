package com.example.demo.service.impl;

import com.example.demo.dto.InvoiceAmountDTO;
import com.example.demo.dto.InvoiceDTO;
import com.example.demo.entity.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    final
    InvoiceRepository invoiceRepository;
    final PaymentRepository paymentRepository;
    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, PaymentRepository paymentRepository) {
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<Invoice> expiredInvoices() {
        return  invoiceRepository.findAllByDueDateAfterAndIssuedDateIsNull(new Date());
    }

    @Override
    public List<InvoiceDTO> wrongDateInvoices() {
        return invoiceRepository.findAllByIssuedDateAfterDueDate();
    }

    @Override
    public List<InvoiceAmountDTO> overPaidInvoices() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<InvoiceAmountDTO> invoiceAmountDTOS= new LinkedList<InvoiceAmountDTO>();
        for(Invoice invoice : invoiceList){
            if(paymentRepository.getAmount(invoice.getId())>invoice.getAmount()){
                invoiceAmountDTOS.add(InvoiceAmountDTO.fromEntity(invoice));
            }
        }
        return invoiceAmountDTOS;
    }

    @Override
    public Invoice getInvoice(Integer id) {
        return invoiceRepository.getById(id);
    }
}
