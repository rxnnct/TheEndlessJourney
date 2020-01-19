package ru.rxnnct.application.characters;


public class GameCharacter {
    protected int currentHitPoints;
    protected int maximumHitPoints;
    protected int characterPositionRow;
    protected int characterPositionCol;
    protected Skill hit;
    protected Skill block;
    protected Skill heal;
    protected Skill leech;
    protected Skill penetrate;
    protected Skill reflect;
    protected boolean healEffect;
    protected boolean blockState;
    protected boolean castState;
    protected boolean damageEffect;
    protected boolean reflectState;
    protected int reflectPower;

    //constructors
    public GameCharacter() {
        hit = new Skill(0, 0, 0 , 2000, 0, 300, 0, 250, false);
        block = new Skill(0, 0, 0 , 1500, 700, 0, 0, 0, false);
        heal = new Skill(0, 0, 0 , 4000, 0, 1000, 500, 0, false);
        leech = new Skill(0, 0, 0 , 3000, 0, 400, 150, 150, true);
        penetrate = new Skill(0, 0, 0 , 4000, 0, 200, 0, 200, true);
        reflect = new Skill(0, 1500, 150 , 5000, 0, 1500, 0, 150, false);
        healEffect = false;
        blockState = false;
        castState = false;
        damageEffect = false;
        reflectState = false;
        reflectPower = 0;
    }

    //accessors
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getCharacterPositionCol() {
        return characterPositionCol;
    }

    public void setCharacterPositionCol(int characterPositionCol) {
        this.characterPositionCol = characterPositionCol;
    }

    public int getCharacterPositionRow() {
        return characterPositionRow;
    }

    public void setCharacterPositionRow(int characterPositionRow) {
        this.characterPositionRow = characterPositionRow;
    }

    //methods

}
