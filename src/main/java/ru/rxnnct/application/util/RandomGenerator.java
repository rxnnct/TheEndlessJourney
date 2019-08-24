package ru.rxnnct.application.util;

import java.util.Random;

public class RandomGenerator extends Random {
    private static RandomGenerator ourInstance = new RandomGenerator(System.currentTimeMillis());

    public static RandomGenerator getInstance() {
        return ourInstance;
    }

    private RandomGenerator(long l) {
    }
}
