package ru.rxnnct.application;

import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.application.util.ApplicationFileHandler;
import ru.rxnnct.userinterface.UserInterface;

import java.io.IOException;

public class Battle {
    private Enemy enemy;

    //constructors
    public Battle(Enemy enemy) {
        Player.getInstance().initializeSkills();
        this.enemy = enemy;
        this.enemy.initializeSkills();
        this.enemy.startFight();
    }

    //accessors
    public Enemy getEnemy() {
        return enemy;
    }

    //methods
    public void killTheEnemy(){
        Player.getInstance().addScore();
        Application.getInstance().setApplicationState(ApplicationStates.MAP);
        Application.getInstance().getCurrentGameMap().getEnemies().remove(enemy);
        UserInterface.getInstance().changeCurrentFrame();
    }

    public void gameOver() throws IOException {
        ApplicationFileHandler.getInstance().saveScore();
        Application.getInstance().setApplicationState(ApplicationStates.GAME_OVER);
        UserInterface.getInstance().changeCurrentFrame();
        UserInterface.getInstance().drawGameOver();
    }
}
