package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Payment;
import com.example.demo.request.OrderRequest;
import com.example.demo.request.PaymentRequest;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    final
    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseDTO createPayment(@RequestBody PaymentRequest request) {
        return paymentService.createPayment(request);
    }

    @GetMapping("/details")
    public Payment getPayment(
            @RequestParam("payment_details_id") Integer paymentId
    ) {
        return paymentService.getPayment(paymentId);
    }
}
