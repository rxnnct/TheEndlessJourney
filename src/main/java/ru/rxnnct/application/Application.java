package ru.rxnnct.application;

import ru.rxnnct.userinterface.UserInterface;

public class Application {
    private ApplicationStates applicationState;
    private UserInterface userInterface;

    //constructor
    public Application() {
        this.applicationState = ApplicationStates.MENU;
        this.userInterface = new UserInterface();
    }
}
