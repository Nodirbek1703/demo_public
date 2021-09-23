package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class InvoiceDTO {
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dueDate;
    private Integer orderId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderDate;
}
