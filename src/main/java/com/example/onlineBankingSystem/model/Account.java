package com.example.onlineBankingSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name="Account")
public class Account {
    public Long getAccountId() {
        return accountId;
    }

    @Id
    @Column(name="account_id")
    private Long accountId;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customerId;
    @Enumerated(value=EnumType.STRING)
    @Column(name="account_type")
    private AccountType accountType;
    @Column(name="balance")
    private Double balance;
    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Double getBalance() {
        return balance;
    }
    public Customer getCustomerId() {
        return customerId;
    }
}
