package com.example.onlineBankingSystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Withdraw {
    private Long accountId;
    private double amount;

    public Long getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
