package com.example.onlineBankingSystem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message)
    {
        super(message);
    }

}
