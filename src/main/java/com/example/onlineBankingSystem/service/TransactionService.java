package com.example.onlineBankingSystem.service;
import com.example.onlineBankingSystem.exception.AccountNotFoundException;
import com.example.onlineBankingSystem.exception.InsufficientBalanceException;
import com.example.onlineBankingSystem.model.*;
import com.example.onlineBankingSystem.repository.AccountRepository;
import com.example.onlineBankingSystem.repository.TransactionRepository;
import com.example.onlineBankingSystem.util.RandomNumberTransaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction deposit(Deposit deposit) {
        Optional<Account> existAccountId = accountRepository.findById(deposit.getAccountId());
        if (existAccountId.isPresent()) {
            Account account1 = existAccountId.get();
            Double currentBalance = account1.getBalance();
            Double newBalance = currentBalance + deposit.getAmount();
            account1.setBalance(newBalance);
            accountRepository.save(account1);
            // transaction
            Transaction transactionDeposit = new Transaction();
            Long generateTransactionId = RandomNumberTransaction.generateRandomLongId();
            transactionDeposit.setTransactionId(generateTransactionId);
            transactionDeposit.setAccount(account1);
            transactionDeposit.setAmount(deposit.getAmount());
            transactionDeposit.setTransactionType("DEPOSIT");
            transactionDeposit.setTransactionMessage("Deposited successfully");
            transactionDeposit.setTransactionDate(LocalDateTime.now());
            return transactionRepository.save(transactionDeposit);
        } else {
            return null;
        }
    }

    @Transactional
    public Transaction withdraw(Withdraw withdraw) {
        Optional<Account> existAccountId = accountRepository.findById(withdraw.getAccountId());
        if (existAccountId.isPresent()) {
            Account account = existAccountId.get();
            if (account.getBalance() < withdraw.getAmount()) {
                throw new InsufficientBalanceException("Insufficient balance!!");
            }
            else {
                Double currentBalance = account.getBalance();
                Double newBalance = currentBalance - withdraw.getAmount();
                account.setBalance(newBalance);
                accountRepository.save(account);
                Transaction transactionWithdraw = new Transaction();
                Long generateTransactionId = RandomNumberTransaction.generateRandomLongId();
                transactionWithdraw.setTransactionId(generateTransactionId);
                transactionWithdraw.setAccount(account);
                transactionWithdraw.setAmount(withdraw.getAmount());
                transactionWithdraw.setTransactionType("WITHDRAW");
                transactionWithdraw.setTransactionMessage("Withdrawal done successfully");
                transactionWithdraw.setTransactionDate(LocalDateTime.now());
                return transactionRepository.save(transactionWithdraw);
            }
        }
        else {
            return null;

        }
    }
    @Transactional
    public Transaction transfer(Transfer transfer)
    {
        Optional<Account> fromAccount=accountRepository.findById(transfer.getFromAccount());
        Optional<Account> toAccount=accountRepository.findById(transfer.getToAccount());
        if(fromAccount.isPresent() && toAccount.isPresent()) {
            Account fromAccount1 = fromAccount.get();
            Account toAccount1 = toAccount.get();
            if (fromAccount1.getBalance() >= transfer.getAmount()) {
                Double fromAccountNewBalance = fromAccount1.getBalance() - transfer.getAmount();
                Double toAccountNewBalance = toAccount1.getBalance() + transfer.getAmount();
                fromAccount1.setBalance(fromAccountNewBalance);
                toAccount1.setBalance(toAccountNewBalance);
                accountRepository.save(fromAccount1);
                accountRepository.save((toAccount1));
            } else {
                throw new InsufficientBalanceException("Insufficient balance !!");
            }
            Transaction transactionTransfer = new Transaction();
            Long generatedTransactionId = RandomNumberTransaction.generateRandomLongId();
            transactionTransfer.setTransactionId(generatedTransactionId);
            transactionTransfer.setAccount(fromAccount1);
            transactionTransfer.setAmount(transfer.getAmount());
            transactionTransfer.setTransactionType("TRANSFER");
            transactionTransfer.setTransactionMessage("Amount transferred successfully");
            transactionTransfer.setTransactionDate(LocalDateTime.now());
            return transactionRepository.save(transactionTransfer);
        }
        else {
            return null;
        }

    }

    public List<Transaction> getTransactionHistoryByAccountId(Long accountId) {
        List<Transaction> transaction =transactionRepository.findByAccountAccountId(accountId);
        return transaction;
    }
}
