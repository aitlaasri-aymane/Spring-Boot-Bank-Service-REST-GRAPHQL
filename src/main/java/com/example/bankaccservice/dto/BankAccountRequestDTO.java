package com.example.bankaccservice.dto;

import com.example.bankaccservice.enums.AccoutType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccoutType accoutType;
    private RequestCustomerDTO customerDTO;
}
