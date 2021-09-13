package com.example.demo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
public class ResponseDTO {
    private String statusMessage;
    private Object data;

    public ResponseDTO(Object data,String statusMessage) {
        this.statusMessage = statusMessage;
        this.data = data;
    }
}