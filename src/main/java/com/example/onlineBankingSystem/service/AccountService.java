package com.example.onlineBankingSystem.service;
import com.example.onlineBankingSystem.model.Account;
import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.repository.AccountRepository;
import com.example.onlineBankingSystem.repository.CustomerRepository;
import com.example.onlineBankingSystem.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public Account createAccount(Account account) {

        Long customerId = account.getCustomerId().getcustomerId();

        Optional<Customer> existingCustomer = customerRepository.findByCustomerId(customerId);

        if (existingCustomer.isEmpty()) {
            return null; // customer doesn't exist
        }

        Long randomAccountId = RandomNumber.generateRandomLongId();
        account.setAccountId(randomAccountId);
        account.setCustomerId(existingCustomer.get());

        return accountRepository.save(account);
    }

    public boolean accountExistsByCustomerId(Long customerId)
    {
        boolean exist = accountRepository.existsByCustomerIdCustomerId(customerId);
        return exist;

    }

    public boolean accountIdExists(Long accountId)
    {
        boolean existAccountId = accountRepository.findByAccountId(accountId).isPresent();
        return existAccountId;
    }

    public Account getAccountDetails(Long customerId)
    {
        Optional<Customer> customerOpt = customerRepository.findByCustomerId(customerId);

        if (customerOpt.isPresent()) {
            Optional<Account> accountOpt = accountRepository.findByCustomerId(customerOpt.get());
            return accountOpt.orElse(null);
        }

        return null;

    }

}

