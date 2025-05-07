package com.example.onlineBankingSystem.repository;

import com.example.onlineBankingSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByEmail(String email);
    Optional<Customer> findByCustomerId(Long customerId);

    Customer findByEmail(String email);
}
