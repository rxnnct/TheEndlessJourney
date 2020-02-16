package ru.rxnnct.application;

import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.userinterface.UserInterface;

public class Battle {
    private Enemy enemy;

    //constructors
    public Battle(Enemy enemy) {
        this.enemy = enemy;
        this.enemy.fight();
        //todo: delete this test
//        new Thread(() -> {
//            try {
//                Thread.sleep(300);
//                Application.getInstance().getCurrentGameMap().getEnemies().remove(enemy);
//                Application.getInstance().setApplicationState(ApplicationStates.MAP);
//                UserInterface.getInstance().changeCurrentFrame();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }

    //accessors
    public Enemy getEnemy() {
        return enemy;
    }

}
