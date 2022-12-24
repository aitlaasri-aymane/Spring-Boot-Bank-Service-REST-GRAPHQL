package com.example.bankaccservice;

import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.entities.Customer;
import com.example.bankaccservice.enums.AccoutType;
import com.example.bankaccservice.repositories.BankAccountRepo;
import com.example.bankaccservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepo bankAccountRepo, CustomerRepo customerRepo){
        return args -> {
            Stream.of("Ahmed","Yassine","Aymane","Mehdi").forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .build();
                customerRepo.save(customer);
            });

            customerRepo.findAll().forEach(customer -> {
            for (int i=0;i<4;i++)
            {
                BankAccount bankAccount = BankAccount.builder()
                        //.id(UUID.randomUUID().toString()) Since we using @GeneratedValue
                        .accoutType(Math.random()>0.5?AccoutType.CURRENT_ACCOUNT:AccoutType.SAVING_ACCOUNT)
                        .balance(Math.random()*90000 + 10000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .customer(customer)
                        .build();
                bankAccountRepo.save(bankAccount);
            }
            });
        };
    }

}
