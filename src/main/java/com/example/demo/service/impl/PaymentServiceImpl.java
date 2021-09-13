package com.example.demo.service.impl;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.request.PaymentRequest;
import com.example.demo.service.InvoiceService;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {


    final PaymentRepository paymentRepository;
    final InvoiceService invoiceService;
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, InvoiceService invoiceService) {
        this.paymentRepository = paymentRepository;
        this.invoiceService = invoiceService;
    }


    @Override
    public ResponseDTO createPayment(PaymentRequest request) {
       Invoice invoice =  invoiceService.getInvoice(request.getInvoiceId());
        Payment payment = new Payment();
        payment.setCreatedDate(new Date());
        payment.setAmount(invoice.getAmount());
        payment.setInvoiceId(invoice.getId());
        payment = paymentRepository.save(payment);
        return new ResponseDTO(payment,"SUCCESS");
    }


    @Override
    public Payment getPayment(Integer paymentId) {
        return paymentRepository.getById(paymentId);
    }
}
