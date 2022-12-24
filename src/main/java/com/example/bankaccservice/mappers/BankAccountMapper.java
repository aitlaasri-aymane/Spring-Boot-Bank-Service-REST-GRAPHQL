package com.example.bankaccservice.mappers;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class BankAccountMapper {
    CustomerMapper customerMapper;
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder().build();
        bankAccountResponseDTO.setCustomerDTO(customerMapper.fromCustomer(bankAccount.getCustomer()));
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    public BankAccount toBankAccount(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount bankAccount = BankAccount.builder().build();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }
}
