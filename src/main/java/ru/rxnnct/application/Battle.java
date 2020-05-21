package ru.rxnnct.application;

import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.application.util.FileHandler;
import ru.rxnnct.userinterface.UserInterface;

import java.io.IOException;

public class Battle {
    private Enemy enemy;

    //constructors
    public Battle(Enemy enemy) {
        this.enemy = enemy;
        this.enemy.startFight();
    }

    //accessors
    public Enemy getEnemy() {
        return enemy;
    }

    public void killTheEnemy(){
        Player.getInstance().addScore();
        Application.getInstance().getCurrentGameMap().getEnemies().remove(enemy);
        Application.getInstance().setApplicationState(ApplicationStates.MAP);
        UserInterface.getInstance().changeCurrentFrame();
    }

    public void gameOver() throws IOException {
        //todo: save score
        FileHandler.getInstance().saveScore();
        Application.getInstance().setApplicationState(ApplicationStates.GAME_OVER);
        UserInterface.getInstance().changeCurrentFrame();
    }
}
