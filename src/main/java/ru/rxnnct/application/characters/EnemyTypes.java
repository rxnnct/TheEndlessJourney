package ru.rxnnct.application.characters;

import ru.rxnnct.application.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EnemyTypes {
    FANATIC(0),
    NORMAL(1),
    GUARDIAN(2);

    private final int number;

    EnemyTypes(int s) {
        number = s;
    }

    private static final List<EnemyTypes> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EnemyTypes randomEnemyType()  {
        return VALUES.get(RandomGenerator.getInstance().nextInt(SIZE));
    }

    public int getNumber() {
        return number;
    }
}
