package ru.rxnnct.application.characters;

public class Enemy extends GameCharacter {
    private EnemyTypes enemyType;
    private int BASE_HIT_POINTS = 500;
    private int BONUS_HIT_POINTS_PER_STAGE = 200;

    //constructors
    public Enemy(int characterPositionRow, int characterPositionCol){
        this.characterPositionRow = characterPositionRow;
        this.characterPositionCol = characterPositionCol;
        //todo: add initialization here
        maximumHitPoints = BASE_HIT_POINTS + Player.getInstance().getCurrentStage() * BONUS_HIT_POINTS_PER_STAGE;
        currentHitPoints = maximumHitPoints;
        enemyType = EnemyTypes.randomEnemyType();


    }
}
