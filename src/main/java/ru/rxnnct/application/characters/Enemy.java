package ru.rxnnct.application.characters;

public class Enemy extends GameCharacter {
    private EnemyTypes enemyType;
    private int BASE_HIT_POINTS = 500;
    private int BONUS_HIT_POINTS_PER_STAGE = 200;
    private ArtificialIntelligence artificialIntelligence;

    //constructors
    public Enemy(int characterPositionRow, int characterPositionCol){
        this.characterPositionRow = characterPositionRow;
        this.characterPositionCol = characterPositionCol;
        this.maximumHitPoints = BASE_HIT_POINTS + Player.getInstance().getCurrentStage() * BONUS_HIT_POINTS_PER_STAGE;
        this.currentHitPoints = maximumHitPoints;
        this.enemyType = EnemyTypes.randomEnemyType();
        this.artificialIntelligence = new ArtificialIntelligence(this);
    }

    //accessors
    public EnemyTypes getEnemyType() {
        return enemyType;
    }

    //methods
    public int getEnemyTypeNumber(){
        return enemyType.getNumber();
    }

    public void startFight(){
        artificialIntelligence.start();
    }

}
