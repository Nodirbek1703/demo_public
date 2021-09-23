package com.example.demo.dto;

import com.example.demo.entity.Invoice;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class InvoiceAmountDTO {
    private Integer id;
    private Double amount;

    public static InvoiceAmountDTO fromEntity(Invoice invoice){
        InvoiceAmountDTO invoiceAmountDTO = new InvoiceAmountDTO();
        invoiceAmountDTO.setId(invoice.getId());
        invoiceAmountDTO.setAmount(invoice.getAmount());
        return invoiceAmountDTO;
    }
}
