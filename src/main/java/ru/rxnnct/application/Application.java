package ru.rxnnct.application;

import ru.rxnnct.userinterface.UserInterface;

public class Application {

    private ApplicationStates applicationState;
    private UserInterface userInterface;

    //constructor
    public Application() {
        applicationState = ApplicationStates.MENU;
        userInterface = new UserInterface();
        userInterface.drawMainMenu();
    }
}
