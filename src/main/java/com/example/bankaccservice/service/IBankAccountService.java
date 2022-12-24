package com.example.bankaccservice.service;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;

import java.util.List;

public interface IBankAccountService {
    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO updateBankAccount(String id,BankAccountRequestDTO bankAccountDTO);
    List<BankAccountResponseDTO> findAllBankAccounts();
}
