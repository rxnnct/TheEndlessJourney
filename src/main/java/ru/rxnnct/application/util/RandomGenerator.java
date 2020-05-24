package ru.rxnnct.application.util;

import java.util.Random;

public class RandomGenerator extends Random {
    private static RandomGenerator ourInstance = new RandomGenerator(System.currentTimeMillis());

    //accessors
    public static RandomGenerator getInstance() {
        return ourInstance;
    }

    //constructors
    private RandomGenerator(long l) {
    }
}
