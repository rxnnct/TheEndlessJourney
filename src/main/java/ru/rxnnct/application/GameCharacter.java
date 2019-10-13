package ru.rxnnct.application;

public class GameCharacter {
    private int currentHitPoints;
    protected int characterPositionRow;
    protected int characterPositionCol;

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
    public void changeCharacterPositionRow(int characterPositionDelta){
        this.characterPositionRow = this.characterPositionRow + characterPositionDelta;
    }

    public void changeCharacterPositionCol(int characterPositionDelta){
        this.characterPositionCol = this.characterPositionCol + characterPositionDelta;
    }
}
