package com.example.bankaccservice.entities;

import com.example.bankaccservice.enums.AccoutType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "p1") // use by going to /bankAccounts?projection=p1
public interface BankAccountProjection {
    String getId();
    Double getBalance();
    AccoutType getAccoutType();
}
