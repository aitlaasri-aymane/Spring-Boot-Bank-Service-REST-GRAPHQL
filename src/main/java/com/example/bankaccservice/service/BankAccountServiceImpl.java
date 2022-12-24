package com.example.bankaccservice.service;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.entities.Customer;
import com.example.bankaccservice.mappers.BankAccountMapper;
import com.example.bankaccservice.mappers.CustomerMapper;
import com.example.bankaccservice.repositories.BankAccountRepo;
import com.example.bankaccservice.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements IBankAccountService {
    BankAccountRepo bankAccountRepo;
    CustomerRepo customerRepo;
    BankAccountMapper bankAccountMapper;
    CustomerMapper customerMapper;
    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountDTO) {
        Customer customer = customerRepo.findById(bankAccountDTO.getCustomerDTO().getId()).orElseThrow(()-> new RuntimeException("Customer not found"));
        BankAccount bankAccount = bankAccountMapper.toBankAccount(bankAccountDTO);
        bankAccount.setCreatedAt(new Date());
        bankAccount.setCustomer(customer);
        BankAccount savedBankAccount = bankAccountRepo.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO =bankAccountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account "+id+" not found"));
        if(bankAccountDTO.getAccoutType() != null) bankAccount.setAccoutType(bankAccountDTO.getAccoutType());
        if(bankAccountDTO.getBalance() != null) bankAccount.setBalance(bankAccountDTO.getBalance());
        bankAccount.setCreatedAt(new Date());
        if(bankAccountDTO.getCurrency() != null) bankAccount.setCurrency(bankAccountDTO.getCurrency());
        if(bankAccountDTO.getCustomerDTO() != null) {
            System.out.println(bankAccountDTO.getCustomerDTO().getId());
            Customer customer = customerRepo.findById(bankAccountDTO.getCustomerDTO().getId()).orElseThrow(()-> new RuntimeException("Customer not found"));
            bankAccount.setCustomer(customer);
        };
        BankAccount updatedAccount = bankAccountRepo.save(bankAccount);
        return bankAccountMapper.fromBankAccount(updatedAccount);
    }

    @Override
    public List<BankAccountResponseDTO> findAllBankAccounts() {
        List<BankAccount> bankAccountList = bankAccountRepo.findAll();
        List<BankAccountResponseDTO> bankAccountResponseDTOList = new ArrayList<>();
        bankAccountList.forEach(bankAccount -> {
            bankAccountResponseDTOList.add(bankAccountMapper.fromBankAccount(bankAccount));
        });
        return bankAccountResponseDTOList;
    }


}
