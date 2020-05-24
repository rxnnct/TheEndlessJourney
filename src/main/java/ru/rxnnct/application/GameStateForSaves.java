package ru.rxnnct.application;

import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.EnemyPositionForSaves;
import ru.rxnnct.application.characters.Player;

import java.util.ArrayList;

public class GameStateForSaves {
    public int currentStage;
    public int score;
    public int currentHitPoints;
    public int characterPositionRow;
    public int characterPositionCol;
    public int[][] map;
    public ArrayList<EnemyPositionForSaves> enemyPositions = new ArrayList<>();

    //constructors
    public GameStateForSaves() {
        this.currentStage = Player.getInstance().getCurrentStage();
        this.score = Player.getInstance().getScore();
        this.currentHitPoints = Player.getInstance().getCurrentHitPoints();
        this.characterPositionRow = Player.getInstance().getCharacterPositionRow();
        this.characterPositionCol = Player.getInstance().getCharacterPositionCol();
        this.map = Application.getInstance().getCurrentGameMap().getMap();
        for (Enemy enemy : Application.getInstance().getCurrentGameMap().getEnemies()) {
            EnemyPositionForSaves position = new EnemyPositionForSaves(enemy.getCharacterPositionRow(), enemy.getCharacterPositionCol());
            this.enemyPositions.add(position);
        }
    }

}
