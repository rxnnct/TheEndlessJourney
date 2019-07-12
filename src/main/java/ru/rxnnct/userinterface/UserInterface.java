package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
    private static UserInterface ourInstance = new UserInterface();
    private MainFrame mainFrame;
    private MainMenu mainMenu;
    private Help help;

    //constructor
    private UserInterface() {
        mainFrame = new MainFrame();
    }

    //instance
    public static UserInterface getInstance() {
        return ourInstance;
    }

    //accessors
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Help getHelp() {
        return help;
    }

    //methods
    public void drawMainMenu(){
        mainMenu = new MainMenu();
        mainFrame.getFrame().add(mainMenu);
        mainFrame.getFrame().getContentPane().setBackground(Color.white);
    }

    public void drawHelp(){
        help = new Help();
        mainFrame.getFrame().add(help);
        mainFrame.getFrame().getContentPane().setBackground(Color.white);
    }

    public void changeApplicationState(ApplicationStates applicationState){
        Application.getInstance().setApplicationState(applicationState);
    }

    public void changeCurrentFrame() { //execute (old name)
        switch(Application.getInstance().getApplicationState()) {
            case MENU:
                mainFrame.getFrame().add(mainMenu);
                break;
//            case 1:
//                w.add(canvMap);
//                GameMap.changeCurrentFrame();
//                break;
//            case 2:
//                w.add(canvBattle);
//                GameBattle.enemy.artificialIntelligence();
//                break;
//            case 3:
//                w.add(canvResult);
//                break;
//            case 4:
//                w.add(canvStats);
//                break;
//            case 5:
//                w.add(canvAbout);
//                break;
        }
        mainFrame.getFrame().setVisible(true);
    }
}
