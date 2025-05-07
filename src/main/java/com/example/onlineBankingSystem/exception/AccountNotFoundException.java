package com.example.onlineBankingSystem.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message)
    {
        super(message);
    }
}
