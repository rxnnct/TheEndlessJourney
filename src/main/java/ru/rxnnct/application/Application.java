package ru.rxnnct.application;

import ru.rxnnct.userinterface.UserInterface;

public class Application {
    private static Application ourInstance = new Application();

    private ApplicationStates applicationState;

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

    public void setApplicationState(ApplicationStates applicationState) {
        this.applicationState = applicationState;
    }
}
