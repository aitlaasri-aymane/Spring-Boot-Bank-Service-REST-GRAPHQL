package com.example.bankaccservice.web;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.entities.Customer;
import com.example.bankaccservice.repositories.BankAccountRepo;
import com.example.bankaccservice.repositories.CustomerRepo;
import com.example.bankaccservice.service.IBankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController { // access through /grqphiql and put query { accounts {id,balance}, bankAccountById(id : "id"){id,balance}  }
    private BankAccountRepo bankAccountRepo;
    private CustomerRepo customerRepo;
    private IBankAccountService iBankAccountService;

    @QueryMapping
    public List<BankAccount> accounts(){ // accounts {id,balance}
        return bankAccountRepo.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){ // bankAccountById(id : "id"){id,balance}
        return bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException("Account "+id+" not found"));
    }

    @MutationMapping
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccount){
        return iBankAccountService.addBankAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument BankAccountRequestDTO bankAccount,@Argument String id){
        return iBankAccountService.updateBankAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteBankAccount(@Argument String id){
        bankAccountRepo.deleteById(id);
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepo.findAll();
    }
}
