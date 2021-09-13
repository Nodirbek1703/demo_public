package com.example.demo.service;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Payment;
import com.example.demo.request.PaymentRequest;

public interface PaymentService {
    ResponseDTO createPayment(PaymentRequest request);

    Payment getPayment(Integer paymentId);
}
