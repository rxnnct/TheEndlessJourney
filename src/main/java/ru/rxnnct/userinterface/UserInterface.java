package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import java.awt.*;

public class UserInterface {
    private static UserInterface ourInstance = new UserInterface();
    private MainFrame mainFrame;
    private MainMenu mainMenu;

    //constructor
    private UserInterface() {
        mainFrame = new MainFrame();
    }

    public static UserInterface getInstance() {
        return ourInstance;
    }

    //accessors
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    //methods
    public void drawMainMenu(){
        mainMenu = new MainMenu();
        mainFrame.getFrame().add(mainMenu);
        mainFrame.getFrame().getContentPane().setBackground(Color.white);
    }

    public void changeApplicationState(ApplicationStates applicationState){
        Application.getInstance().setApplicationState(applicationState);
    }
}
