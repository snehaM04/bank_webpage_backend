package com.example.onlineBankingSystem.model;

public enum AccountType {
    SAVINGS(0),
    CURRENT(1);
    private final int value;

    AccountType(int value) {
        this.value = value;
    }
    public int getValue()
    {
        return value;
    }

}
