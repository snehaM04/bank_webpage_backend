package com.example.onlineBankingSystem.service;

import com.example.onlineBankingSystem.exception.CustomerNotFoundException;
import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.repository.CustomerRepository;
import com.example.onlineBankingSystem.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer)
    {
        Long generateCustomerId = RandomNumber.generateRandomLongId();
        customer.setcustomerId(generateCustomerId);
        boolean checkEmail;
        if (customerRepository.existsByEmail(customer.getEmail())) checkEmail = true;
        else checkEmail = false;
        if(checkEmail)
            return null;
        return customerRepository.save(customer);
    }

    public Customer getCustomerDetails(Long customerId)
    {
        Optional<Customer> customerDetails = customerRepository.findByCustomerId(customerId);
        Customer customer = customerDetails.get();
        return customer;
    }

}
