package ru.rxnnct.application;

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

    public void generation(){
        for (int row = 0; row < MAP_SIZE_ROWS; row++){
            for (int col = 0; col < MAP_SIZE_COLS; col++){
                map[row][col] = MAP_FIELD_EMPTY;
            }
        }
    }
}
