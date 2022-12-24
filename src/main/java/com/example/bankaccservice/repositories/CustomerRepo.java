package com.example.bankaccservice.repositories;

import com.example.bankaccservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
