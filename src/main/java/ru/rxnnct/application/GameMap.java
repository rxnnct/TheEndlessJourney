package ru.rxnnct.application;

import ru.rxnnct.application.util.RandomGenerator;

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

    public void generate(){
        clear();
        createCorridor(true, MAP_SIZE_COLS, MAP_SIZE_ROWS, CORRIDORS_IN_ROWS);
        createCorridor(false, MAP_SIZE_ROWS, MAP_SIZE_COLS, CORRIDORS_IN_COLS);

        //begin test output
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
        int[][] endsArray = new int[2][(CORRIDORS_IN_ROWS + CORRIDORS_IN_COLS) * 2]; //two ends (for generating exit)
        int corridorCounter = 0; //lines
        for (int i = 0; i < numberOfLines; i++) {
            temporaryList.add(i);
        }
        while (corridorCounter < corridorsAcrossLine){
            int nextCorridorLocation = temporaryList.get(RandomGenerator.getInstance().nextInt(temporaryList.size()));
            for (int i = 0; i < temporaryList.size(); i++) { //delete by index of list
                if (temporaryList.get(i) == nextCorridorLocation){
                    temporaryList.remove(i);
                }
            }
            int counter = 0;
            for (int i = 0; i < lineLength; i++){
                if (isHorisontal == true){
                    map[nextCorridorLocation][i] = MAP_FIELD_CORRIDOR;
                    if (i == 0){
                        endsArray[0][counter] = nextCorridorLocation;
                        endsArray[1][counter] = 0;
                        counter++;
                    }
                    if (i == lineLength - 1){
                        endsArray[0][counter] = nextCorridorLocation;
                        endsArray[1][counter] = lineLength - 1;
                        counter++;
                    }
                } else {
                    map[i][nextCorridorLocation] = MAP_FIELD_CORRIDOR;
                    if (i == 0){
                        endsArray[0][counter] = 0;
                        endsArray[1][counter] = nextCorridorLocation;
                        counter++;
                    }
                    if (i == lineLength - 1){
                        endsArray[0][counter] = lineLength - 1;
                        endsArray[1][counter] = nextCorridorLocation;
                        counter++;
                    }
                }
            }
            corridorCounter++;
        }
        //begin test output -------
        for (int row = 0; row < 2; row++){
            for (int col = 0; col < 2; col++){
                System.out.print(endsArray[row][col] + " ");
            }
            System.out.println();
        }
        //end
    }

}
