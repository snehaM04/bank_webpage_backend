package com.example.onlineBankingSystem.util;

import java.util.Random;

public class RandomNumberTransaction {

    public static long generateRandomLongId() {
        Random random = new Random();
        return 100000000000L + (long) (random.nextDouble() * 899999999999L);
    }

}
