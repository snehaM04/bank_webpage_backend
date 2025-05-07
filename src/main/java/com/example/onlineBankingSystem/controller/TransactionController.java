package com.example.onlineBankingSystem.controller;

import com.example.onlineBankingSystem.exception.AccountNotFoundException;
import com.example.onlineBankingSystem.exception.TransactionNotFoundException;
import com.example.onlineBankingSystem.model.*;
import com.example.onlineBankingSystem.repository.AccountRepository;
import com.example.onlineBankingSystem.service.AccountService;
import com.example.onlineBankingSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody Deposit deposit)
    {
        Transaction transactionDeposit = transactionService.deposit(deposit);
        if(transactionDeposit == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Deposited successfully..!!");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdrawal(@RequestBody Withdraw withdraw) {
        Transaction transactionWithdraw = transactionService.withdraw(withdraw);
        if (transactionWithdraw == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account not found");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body("Withdrawal done successfully...");
        }
    }
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody Transfer transfer)
    {
        Transaction transactionTransfer = transactionService.transfer(transfer);
        if(transactionTransfer == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account not found");
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body("Amount transferred from " + transfer.getFromAccount() + " to " + transfer.getToAccount() + " Successfully!!");
        }
    }
    @GetMapping("/transactionHistory")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@RequestParam(value="accountId") Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));
        List<Transaction> transactions = transactionService.getTransactionHistoryByAccountId(account.getAccountId());
        if (transactions.isEmpty()) {
            throw new TransactionNotFoundException("Transaction details are not found for this account Id " + accountId);
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

}
