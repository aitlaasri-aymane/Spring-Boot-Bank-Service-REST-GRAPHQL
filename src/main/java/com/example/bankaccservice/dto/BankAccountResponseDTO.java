package com.example.bankaccservice.dto;

import com.example.bankaccservice.enums.AccoutType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccoutType accoutType;
    private ResponseCustomerDTO customerDTO;
}
