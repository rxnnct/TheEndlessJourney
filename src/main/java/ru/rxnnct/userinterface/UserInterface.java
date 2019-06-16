package ru.rxnnct.userinterface;

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
}
