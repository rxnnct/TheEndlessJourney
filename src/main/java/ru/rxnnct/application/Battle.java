package ru.rxnnct.application;

import ru.rxnnct.userinterface.UserInterface;

public class Battle {
    private Enemy enemy;

    public Battle(Enemy enemy) {
        this.enemy = enemy;

        //todo: delete this test
        Application.getInstance().getCurrentGameMap().getEnemies().remove(enemy);
        Application.getInstance().setApplicationState(ApplicationStates.MAP);
        UserInterface.getInstance().changeCurrentFrame();

    }

}
