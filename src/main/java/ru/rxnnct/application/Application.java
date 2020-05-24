package ru.rxnnct.application;

import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.application.util.ApplicationFileHandler;
import ru.rxnnct.userinterface.UserInterface;

import java.io.IOException;

public class Application {
    private static Application ourInstance = new Application();

    private ApplicationStates applicationState;
    private GameMap currentGameMap;
    private Battle currentBattle;

    //constructors
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

    public Battle getCurrentBattle() {
        return currentBattle;
    }

    public void setApplicationState(ApplicationStates applicationState) {
        this.applicationState = applicationState;
    }

    //methods
    public void nextLevel(){
        Player.getInstance().nextStage();
        currentGameMap = new GameMap(true);
        Player.getInstance().setCurrentHitPoints(Player.MAXIMUM_HIT_POINTS);
    }

    public void newGame(){
        Player.getInstance().setCurrentStage(0);
        Player.getInstance().setScore(0);
        nextLevel();
    }

    public void continueGame() throws IOException {
        currentGameMap = new GameMap(false);
        ApplicationFileHandler.getInstance().loadGame();
    }

    public void startBattle(Enemy enemy){
        applicationState = ApplicationStates.BATTLE;
        currentBattle = new Battle(enemy);
        UserInterface.getInstance().changeCurrentFrame();
    }

}
