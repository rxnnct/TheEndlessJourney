package ru.rxnnct.application;

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
        createCorridor();

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

    private void createCorridor(){
        ArrayList<Integer> temporaryList = new ArrayList<Integer>();
        temporaryList.clear();
        int[][] startArray = new int[2][(CORRIDORS_IN_ROWS + CORRIDORS_IN_COLS) * 2];
    }

}
