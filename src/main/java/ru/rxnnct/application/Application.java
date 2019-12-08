package ru.rxnnct.application;

import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.userinterface.UserInterface;

public class Application {
    private static Application ourInstance = new Application();

    private ApplicationStates applicationState;
    private GameMap currentGameMap;

    //constructor
    private Application() {
        applicationState = ApplicationStates.MENU;
        UserInterface.getInstance().drawMainMenu();
    }

    public static Application getInstance() {
        return ourInstance;
    }

    //accessors
    public ApplicationStates getApplicationState() {
        return applicationState;
    }

    public GameMap getCurrentGameMap() {
        return currentGameMap;
    }

    public void setApplicationState(ApplicationStates applicationState) {
        this.applicationState = applicationState;
    }

    //methods
    public void nextLevel(){
        currentGameMap = new GameMap();
        Player.getInstance().nextStage();
        Player.getInstance().setCurrentHitPoints(Player.MAXIMUM_HIT_POINTS);
    }

    public void newGame(){
        Player.getInstance().setCurrentStage(0);
        Player.getInstance().setScore(0);
        nextLevel();
    }

    public void startBattle(Enemy enemy){
        this.applicationState = ApplicationStates.BATTLE;
        Battle battle = new Battle(enemy);
        UserInterface.getInstance().changeCurrentFrame();
    }

}
