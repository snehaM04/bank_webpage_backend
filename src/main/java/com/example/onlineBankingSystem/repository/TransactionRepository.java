package com.example.onlineBankingSystem.repository;
import com.example.onlineBankingSystem.model.Transaction;
import com.example.onlineBankingSystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByAccountAccountId(Long accountId);
}
