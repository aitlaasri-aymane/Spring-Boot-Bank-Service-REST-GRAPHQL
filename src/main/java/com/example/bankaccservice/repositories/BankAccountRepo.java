package com.example.bankaccservice.repositories;

import com.example.bankaccservice.entities.BankAccount;
import com.example.bankaccservice.enums.AccoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource // creates rest controller automatically needs the data-rest dependency
public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byType") // /search/byType?t=SAVING_ACCOUNT
    List<BankAccount> findBankAccountByAccoutType(@Param("t") AccoutType type); // to access go to /search and add ?type= if we didnt have the path above
}
