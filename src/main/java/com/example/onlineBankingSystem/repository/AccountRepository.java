package com.example.onlineBankingSystem.repository;
import com.example.onlineBankingSystem.model.Account;
import com.example.onlineBankingSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountId(Long accountId);
    Optional<Account> findByCustomerId(Customer customerId);
    boolean existsByCustomerIdCustomerId(Long customerId);
}
