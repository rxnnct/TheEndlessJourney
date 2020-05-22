package ru.rxnnct.application.characters;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.GameMap;

public class Player extends GameCharacter {
    public static final int MAXIMUM_HIT_POINTS = 3000;
    private static Player ourInstance = new Player();
    private int currentStage;
    private int score;

    //constructors
    private Player() {
        maximumHitPoints = MAXIMUM_HIT_POINTS;
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

    //WARNING!!! Maybe need this.* in methods:
    public void stepUp(){
        if (characterPositionRow != 0){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow - 1][characterPositionCol]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionRow--;
                    checkEnemy();
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    Application.getInstance().getCurrentGameMap().newStage();
                    break;
            }
        }
    }

    public void stepDown(){
        if (characterPositionRow != GameMap.MAP_SIZE_ROWS - 1){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow + 1][characterPositionCol]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionRow++;
                    checkEnemy();
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    Application.getInstance().getCurrentGameMap().newStage();
                    break;
            }
        }
    }

    public void stepLeft(){
        if (characterPositionCol != 0){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow][characterPositionCol - 1]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionCol--;
                    checkEnemy();
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    Application.getInstance().getCurrentGameMap().newStage();
                    break;
            }
        }
    }

    public void stepRight(){
        if (characterPositionCol != GameMap.MAP_SIZE_COLS - 1){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow][characterPositionCol + 1]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionCol++;
                    checkEnemy();
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    Application.getInstance().getCurrentGameMap().newStage();
                    break;
            }
        }
    }

    private void checkEnemy(){
        for (Enemy enemy: Application.getInstance().getCurrentGameMap().getEnemies()){
            if (enemy.getCharacterPositionCol() == characterPositionCol
                    &&  enemy.getCharacterPositionRow() == characterPositionRow){
//                System.out.println("IS ENEMY");
//                System.out.println(enemy.hashCode());
                Application.getInstance().startBattle(enemy);
                break;
            }
        }
    }

    public void addScore(){
        score += 15 * currentStage;
    }

}
