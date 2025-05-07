package com.example.onlineBankingSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@Table(name="Transaction")
public class Transaction {
    @Id
    @Column(name ="transaction_id")
    private Long transactionId;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @Column(name="transaction_type")
    private String transactionType;
    @Column(name="amount")
    private double amount;
    @Column(name="transaction_date")
    private LocalDateTime transactionDate;

    public String getTransactionMessage() {
        return transactionMessage;
    }

    public void setTransactionMessage(String transactionMessage) {
        this.transactionMessage = transactionMessage;
    }

    @Column(name="transaction_message")
    private String transactionMessage;
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    public double getAmount() {
        return amount;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
