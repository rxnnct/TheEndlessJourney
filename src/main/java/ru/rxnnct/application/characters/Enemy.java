package ru.rxnnct.application.characters;

public class Enemy extends GameCharacter {
    private EnemyTypes enemyType;
    private int BASE_HIT_POINTS = 500;
    private int BONUS_HIT_POINTS_PER_STAGE = 200;
    private double hitPriorityRate;
    private double blockPriorityRate;
    private double healPriorityRate;
    private double leechPriorityRate;
    private double penetratePriorityRate;
    private double reflectPriorityRate;
    private int[][] priorityArray = new int[2][6];

    //constructors
    public Enemy(int characterPositionRow, int characterPositionCol){
        this.characterPositionRow = characterPositionRow;
        this.characterPositionCol = characterPositionCol;
        this.maximumHitPoints = BASE_HIT_POINTS + Player.getInstance().getCurrentStage() * BONUS_HIT_POINTS_PER_STAGE;
        this.currentHitPoints = maximumHitPoints;
        this.enemyType = EnemyTypes.randomEnemyType();
        //todo: --- mb move to enemy types
        switch (enemyType){
            case FANATIC:
                hitPriorityRate = 1;
                blockPriorityRate = 0.5;
                healPriorityRate = 0.5;
                leechPriorityRate = 1.5;
                penetratePriorityRate = 1.5;
                reflectPriorityRate = 1;
                break;
            case NORMAL:
                hitPriorityRate = 1.5;
                blockPriorityRate = 1;
                healPriorityRate = 1;
                leechPriorityRate = 0.5;
                penetratePriorityRate = 1.5;
                reflectPriorityRate = 0.5;
                break;
            case GUARDIAN:
                hitPriorityRate = 1;
                blockPriorityRate = 1.5;
                healPriorityRate = 1.5;
                leechPriorityRate = 0.5;
                penetratePriorityRate = 0.5;
                reflectPriorityRate = 1;
                break;
        }
        for (int i = 0; i < 6; i++) {
            priorityArray[0][i] = 200; //start value
            priorityArray[1][i] = 300; //max value
        }

    }

    //accessors
    public EnemyTypes getEnemyType() {
        return enemyType;
    }

    //methods
    public int getEnemyTypeNumber(){
        return enemyType.getNumber();
    }

    public void fight(){
        new Thread(() -> {
            System.out.println("AI HERE");
        }).start();
    }


}
