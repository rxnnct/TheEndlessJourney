package ru.rxnnct.application.characters;

public class EnemyPositionForSaves {
    private int enemyPositionRow;
    private int enemyPositionCol;

    //constructors
    public EnemyPositionForSaves(int enemyPositionRow, int enemyPositionCol) {
        this.enemyPositionRow = enemyPositionRow;
        this.enemyPositionCol = enemyPositionCol;
    }

    //accessors
    public int getEnemyPositionRow() {
        return enemyPositionRow;
    }

    public int getEnemyPositionCol() {
        return enemyPositionCol;
    }
}
