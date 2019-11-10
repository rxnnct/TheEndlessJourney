package ru.rxnnct.application;

import ru.rxnnct.application.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EnemyTypes {
    FANATIC,
    NORMAL,
    GUARDIAN;

    private static final List<EnemyTypes> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EnemyTypes randomEnemyType()  {
        return VALUES.get(RandomGenerator.getInstance().nextInt(SIZE));
    }
}
