package com.example.bankaccservice.web;

import com.example.bankaccservice.dto.BankAccountRequestDTO;
import com.example.bankaccservice.dto.BankAccountResponseDTO;
import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.repositories.BankAccountRepo;
import com.example.bankaccservice.service.IBankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {
    private BankAccountRepo bankAccountRepo;
    private IBankAccountService iBankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccountList(){
        return iBankAccountService.findAllBankAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepo.findById(id).orElseThrow(()->new RuntimeException("Account "+id+" not found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return iBankAccountService.addBankAccount(bankAccountRequestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id,@RequestBody BankAccountRequestDTO bankAccount){
        return iBankAccountService.updateBankAccount(id,bankAccount);
    }

    @DeleteMapping("/bankAccounts")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepo.deleteById(id);
    }
}
