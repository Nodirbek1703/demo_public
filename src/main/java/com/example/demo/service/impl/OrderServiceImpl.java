package com.example.demo.service.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Details;
import com.example.demo.entity.Invoice;
import com.example.demo.entity.Order;
import com.example.demo.repository.DetailsRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.request.OrderRequest;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    final DetailsRepository detailsRepository;
    final ProductService productService;
    final InvoiceRepository invoiceRepository;

    public OrderServiceImpl(OrderRepository orderRepository, DetailsRepository detailsRepository, ProductService productService, InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.detailsRepository = detailsRepository;
        this.productService = productService;
        this.invoiceRepository = invoiceRepository;
    }


    @Override
    public ResponseDTO createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setOrderDate(new Date());
        order=orderRepository.save(order);
        Details details = new Details();
        details.setQuantity(request.getQuantity());
        details.setOrderId(order.getId());
        details.setProductId(request.getProductId());
        detailsRepository.save(details);
        Invoice invoice = new Invoice();
        invoice.setOrderId(order.getId());
        invoice.setAmount(request.getQuantity()*productService.getProduct(request.getProductId()).getPrice());
        invoice.setIssuedDate(new Date());
        invoice = invoiceRepository.save(invoice);
        return new ResponseDTO(invoice.getId(),"SUCCESS");
    }

    @Override
    public Order getOne(Integer id) {
        if (id==null)return null;
        return orderRepository.getById(id);
    }

    @Override
    public OrderDTO getOrder(Integer orderId) {
        return OrderDTO.fromEntity(getOne(orderId),productService);

    }
}
