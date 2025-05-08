package com.example.onlineBankingSystem.controller;

import com.example.onlineBankingSystem.exception.CustomerNotFoundException;
import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "https://bank-application-frontend-xwa6.onrender.com")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //create new customer
    @PostMapping("/create")
    public ResponseEntity<String> CreateCustomer(@RequestBody Customer customer) {
        Customer updatedCustomer=customerService.createCustomer(customer);
        if(updatedCustomer==null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email already exist");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer profile is created !!"  + customer.getcustomerId());
    }
    @GetMapping("/getDetails/{customerId}")
    public Customer getCustomer(@PathVariable(name = "customerId")Long customerId)
    {
        return customerService.getCustomerDetails(customerId);
    }
}
