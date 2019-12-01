package ru.rxnnct.application;


public class GameCharacter {
    protected int currentHitPoints;
    protected int characterPositionRow;
    protected int characterPositionCol;
    protected Skills hit;
    protected Skills block;
    protected Skills heal;
    protected Skills leech;
    protected Skills penetrate;
    protected Skills reflect;

    //constructors
    public GameCharacter() {
        hit = new Skills(0, 0, 0 , 2000, 0, 300, 0, 250, false);
        block = new Skills(0, 0, 0 , 1500, 700, 0, 0, 0, false);
        heal = new Skills(0, 0, 0 , 4000, 0, 1000, 500, 0, false);
        leech = new Skills(0, 0, 0 , 3000, 0, 400, 150, 150, true);
        penetrate = new Skills(0, 0, 0 , 4000, 0, 200, 0, 200, true);
        reflect = new Skills(0, 1500, 150 , 5000, 0, 1500, 0, 150, false);
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
