package ru.rxnnct.application;

import com.google.gson.Gson;
import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.application.util.Encoder;

import java.util.ArrayList;

public class GameStateForSaves {
    int currentStage;
    int score;
    int currentHitPoints;
    int characterPositionRow;
    int characterPositionCol;
    int[][] map;
//    ArrayList<Enemy> enemies;

    //constructors
    public GameStateForSaves() {
        this.currentStage = Player.getInstance().getCurrentStage();
        this.score = Player.getInstance().getScore();
        this.currentHitPoints = Player.getInstance().getCurrentHitPoints();
        this.characterPositionRow = Player.getInstance().getCharacterPositionRow();
        this.characterPositionCol = Player.getInstance().getCharacterPositionCol();
        this.map = Application.getInstance().getCurrentGameMap().getMap();
//        this.enemies = Application.getInstance().getCurrentGameMap().getEnemies();
        //todo: save enemies
    }
}
