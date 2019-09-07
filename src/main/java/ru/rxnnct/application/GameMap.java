package ru.rxnnct.application;

import ru.rxnnct.application.util.RandomGenerator;

import java.awt.*;
import java.util.ArrayList;

public class GameMap {
    static private int MAP_SIZE_ROWS = 10;
    static private int MAP_SIZE_COLS = 10;
    static private int CORRIDORS_IN_ROWS = 2;
    static private int CORRIDORS_IN_COLS = 2;

    static final private int MAP_FIELD_EMPTY = 0;
    static final private int MAP_FIELD_CORRIDOR = 1;
    static final private int MAP_FIELD_EXIT = 2;
    //static final private int MAP_FIELD_ENEMY = 3; //or make map classes like player

    private int[][] map = new int[MAP_SIZE_ROWS][MAP_SIZE_COLS];
    private int[][] endsArray = new int[2][(CORRIDORS_IN_ROWS + CORRIDORS_IN_COLS) * 2]; //two ends (for generating exit)
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private int endsArrayElementsCounter = 0;

    public void generate(){
        clear();
        createCorridor(true, MAP_SIZE_COLS, MAP_SIZE_ROWS, CORRIDORS_IN_ROWS);
        createCorridor(false, MAP_SIZE_ROWS, MAP_SIZE_COLS, CORRIDORS_IN_COLS);
        createStartAndEndPositions();

        //begin test output-------
        map[Player.getInstance().getCharacterPositionRow()][Player.getInstance().getCharacterPositionCol()] = 5;
        for (int row = 0; row < MAP_SIZE_ROWS; row++){
            for (int col = 0; col < MAP_SIZE_COLS; col++){
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
        //end
    }

    private void clear(){
        for (int row = 0; row < MAP_SIZE_ROWS; row++){
            for (int col = 0; col < MAP_SIZE_COLS; col++){
                map[row][col] = MAP_FIELD_EMPTY;
            }
        }
    }

    private void createCorridor(boolean isHorisontal, int lineLength, int numberOfLines, int corridorsAcrossLine){
        ArrayList<Integer> temporaryList = new ArrayList<>();
        temporaryList.clear();

        int corridorsAcrossLineCounter = 0; //lines
        for (int i = 0; i < numberOfLines; i++) {
            temporaryList.add(i);
        }
        while (corridorsAcrossLineCounter < corridorsAcrossLine){
            int nextCorridorLocation = temporaryList.get(RandomGenerator.getInstance().nextInt(temporaryList.size()));
            for (int i = 0; i < temporaryList.size(); i++) { //delete by index of list
                if (temporaryList.get(i) == nextCorridorLocation){
                    temporaryList.remove(i);
                }
            }
            for (int i = 0; i < lineLength; i++){
                if (isHorisontal){
                    map[nextCorridorLocation][i] = MAP_FIELD_CORRIDOR;
                    if (i == 0){
                        endsArray[0][endsArrayElementsCounter] = nextCorridorLocation;
                        endsArray[1][endsArrayElementsCounter] = 0;
                        endsArrayElementsCounter++;
                    }
                    if (i == lineLength - 1){
                        endsArray[0][endsArrayElementsCounter] = nextCorridorLocation;
                        endsArray[1][endsArrayElementsCounter] = lineLength - 1;
                        endsArrayElementsCounter++;
                    }
                } else {
                    map[i][nextCorridorLocation] = MAP_FIELD_CORRIDOR;
                    if (i == 0){
                        endsArray[0][endsArrayElementsCounter] = 0;
                        endsArray[1][endsArrayElementsCounter] = nextCorridorLocation;
                        endsArrayElementsCounter++;
                    }
                    if (i == lineLength - 1){
                        endsArray[0][endsArrayElementsCounter] = lineLength - 1;
                        endsArray[1][endsArrayElementsCounter] = nextCorridorLocation;
                        endsArrayElementsCounter++;
                    }
                }
            }
            corridorsAcrossLineCounter++;
        }
    }

    private void createStartAndEndPositions(){
        int tempRandStart = RandomGenerator.getInstance().nextInt((endsArray[0].length));
        Player.getInstance().setCharacterPositionRow(endsArray[0][tempRandStart]);
        Player.getInstance().setCharacterPositionCol(endsArray[1][tempRandStart]);
        boolean flag = false;
        int tempRandFinal = 0;
        while (!flag){
            tempRandFinal = RandomGenerator.getInstance().nextInt((endsArray[0].length));
            if (tempRandFinal != tempRandStart){
                flag = true;
            }
        }
        map[endsArray[0][tempRandFinal]][endsArray[1][tempRandFinal]] = MAP_FIELD_EXIT;
    }

}
