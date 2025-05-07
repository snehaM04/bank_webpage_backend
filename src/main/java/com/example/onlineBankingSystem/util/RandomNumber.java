package com.example.onlineBankingSystem.util;

import java.util.Random;

public class RandomNumber {
    public static long generateRandomLongId() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        return (long) randomNumber;
    }

}
