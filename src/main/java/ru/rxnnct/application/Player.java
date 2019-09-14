package ru.rxnnct.application;

public class Player extends GameCharacter  {
    public static final int MAXIMUM_HIT_POINTS = 3000;
    private static Player ourInstance = new Player();
    private int currentStage;
    private int score;

    //constructors
    private Player() {
    }

    //accessors
    public static Player getInstance() {
        return ourInstance;
    }

    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentStage() {
        return currentStage;
    }

    public int getScore() {
        return score;
    }

    //Methods
    public void nextStage() {
        this.currentStage++;
    }

}
