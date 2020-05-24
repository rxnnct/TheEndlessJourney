package ru.rxnnct.application.characters;

import ru.rxnnct.application.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum EnemyTypes {
    FANATIC(0),
    NORMAL(1),
    GUARDIAN(2);

    private static final List<EnemyTypes> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private final int number;

    //constructors
    EnemyTypes(int s) {
        number = s;
    }

    //accessors
    public int getNumber() {
        return number;
    }

    //methods
    public static EnemyTypes randomEnemyType()  {
        return VALUES.get(RandomGenerator.getInstance().nextInt(SIZE));
    }
}
