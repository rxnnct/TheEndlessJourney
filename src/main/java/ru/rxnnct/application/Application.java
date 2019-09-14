package ru.rxnnct.application;

import ru.rxnnct.userinterface.UserInterface;

public class Application {
    private static Application ourInstance = new Application();

    private ApplicationStates applicationState;
    private GameMap currentGameMap = new GameMap();

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


}
