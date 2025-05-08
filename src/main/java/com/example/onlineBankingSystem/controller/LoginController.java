package com.example.onlineBankingSystem.controller;

import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.model.Login;
import com.example.onlineBankingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "https://bank-application-frontend-xwa6.onrender.com")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        Customer customer = customerRepository.findByEmail(login.getEmail());
        if (customer != null && customer.getPassword().equals(login.getPassword())) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful!");
            response.put("customerId", customer.getcustomerId());
            return ResponseEntity.ok(response); // returns as JSON
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Email or password is not valid");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
