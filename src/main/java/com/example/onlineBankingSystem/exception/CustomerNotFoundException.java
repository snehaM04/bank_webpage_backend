package com.example.onlineBankingSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerNotFoundException extends RuntimeException
{
        public CustomerNotFoundException(String message)
        {
            super(message);
        }

}
