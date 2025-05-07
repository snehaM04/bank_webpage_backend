package com.example.onlineBankingSystem.controller;
import com.example.onlineBankingSystem.model.Account;
import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.service.AccountService;
import com.example.onlineBankingSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/existsCustomerId/{customerId}")
    public ResponseEntity<Boolean> accountExists(@PathVariable Long customerId) {
        boolean exists = accountService.accountExistsByCustomerId(customerId);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/existsAccountId/{accountId}")
    public ResponseEntity<Map<String, Object>> accountIdExists(@PathVariable Long accountId) {
        boolean exists = accountService.accountIdExists(accountId);
        Map<String, Object> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);

        Map<String, Object> response = new HashMap<>();

        if (createdAccount == null) {
            response.put("message", "customer does not exist.");

            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        response.put("message", "Account created successfully.");
        response.put("accountId", createdAccount.getAccountId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getAccountDetails/{customerId}")
    public ResponseEntity<Account> getAccountdetails(@PathVariable(name = "customerId") Long customerId)
    {
         Account account = accountService.getAccountDetails(customerId);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
