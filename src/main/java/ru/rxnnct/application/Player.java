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

    //WARNING!!! Maybe need this.* in methods:
    public void stepUp(){
        if (characterPositionRow != 0){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow - 1][characterPositionCol]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionRow--;
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

    public void stepDown(){
        if (characterPositionRow != GameMap.MAP_SIZE_ROWS - 1){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow + 1][characterPositionCol]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionRow++;
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

    public void stepLeft(){
        if (characterPositionCol != 0){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow][characterPositionCol - 1]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionCol--;
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

    public void stepRight(){
        if (characterPositionCol != GameMap.MAP_SIZE_COLS - 1){
            switch (Application.getInstance().getCurrentGameMap().getMap()[characterPositionRow][characterPositionCol + 1]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    characterPositionCol++;
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

}
