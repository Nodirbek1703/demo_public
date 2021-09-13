package com.example.demo.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sun.istack.NotNull;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class OrderRequest {


    @NotNull
    private Integer customerId;

    @NotNull
    private Integer productId;

    @NotNull
    private short quantity;



}
