package ru.rxnnct.application;


public class GameCharacter {
    protected int currentHitPoints;
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

    public void useSkill(Skills skill, GameCharacter targetGameCharacter){
        switch (skill){
            case HIT:
                System.out.println(this.hashCode() + " " + skill + " " + "Target " + targetGameCharacter.hashCode());
                break;
            case BLOCK:
                System.out.println(this.hashCode() + " " + skill + " " + "Target " + targetGameCharacter.hashCode());
                break;
            case HEAL:
                System.out.println(this.hashCode() + " " + skill + " " + "Target " + targetGameCharacter.hashCode());
                break;
            case LEECH:
                System.out.println(this.hashCode() + " " + skill + " " + "Target " + targetGameCharacter.hashCode());
                break;
            case PENETRATE:
                System.out.println(this.hashCode() + " " + skill + " " + "Target " + targetGameCharacter.hashCode());
                break;
            case REFLECT:
                System.out.println(this.hashCode() + " " + skill + " " + "Target " + targetGameCharacter.hashCode());
                break;
        }
    }
}
