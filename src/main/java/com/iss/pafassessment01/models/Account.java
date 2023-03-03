package com.iss.pafassessment01.models;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Account {

    @NotNull(message = "Account cannot be null")
    @Size(min = 10, max = 10, message = "Account id must be 10 characters")
    private String accountId;

    private String name;

    private BigDecimal balance;


    public Account() {
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
