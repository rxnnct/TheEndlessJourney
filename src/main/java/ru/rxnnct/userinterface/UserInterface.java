package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import java.awt.*;

public class UserInterface {
    private static UserInterface ourInstance = new UserInterface();
    private MainFrame mainFrame;
    private MainMenu mainMenu = new MainMenu();
    private Help help = new Help();
    private BattleUserInterface battleUserInterface = new BattleUserInterface();
    private GameMapUserInterface gameMapUserInterface = new GameMapUserInterface();
    private GameOver gameOver = new GameOver();
    private Records records = new Records();

    //constructors
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

    public GameMapUserInterface getGameMapUserInterface() {
        return gameMapUserInterface;
    }

    public BattleUserInterface getBattleUserInterface() {
        return battleUserInterface;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public Records getRecords() {
        return records;
    }

    //methods
    public void drawMainMenu(){
        mainFrame.getFrame().add(mainMenu);
        mainFrame.getFrame().getContentPane().setBackground(Color.white);
    }

//    public void drawHelp(){
//        //help = new Help();
//        mainFrame.getFrame().add(help);
//        mainFrame.getFrame().getContentPane().setBackground(Color.white);
//    }

    public void drawGameMapUserInterface(){
        mainFrame.getFrame().add(gameMapUserInterface);
        mainFrame.getFrame().getContentPane().setBackground(Color.black);
    }

//    public void drawBattleUserInterface(){
//        mainFrame.getFrame().add(battleUserInterface);
//        mainFrame.getFrame().getContentPane().setBackground(Color.white);
//    }

    public void drawGameOver(){
        mainFrame.getFrame().add(gameOver);
        mainFrame.getFrame().getContentPane().setBackground(Color.white);
    }

//    public void drawRecords(){
//        mainFrame.getFrame().add(records);
//        mainFrame.getFrame().getContentPane().setBackground(Color.white);
//    }

    public void changeApplicationState(ApplicationStates applicationState){
        Application.getInstance().setApplicationState(applicationState);
    }

    public void changeCurrentFrame() { //execute (old name)
        //maybe delete
        switch(Application.getInstance().getApplicationState()) {
            case MENU:
                mainFrame.getFrame().add(mainMenu);
                break;
            case MAP:
                mainFrame.getFrame().add(gameMapUserInterface);
                break;
            case BATTLE:
                mainFrame.getFrame().add(battleUserInterface);
                break;
            case GAME_OVER:
                mainFrame.getFrame().add(gameOver);
                break;
            case RECORDS:
                mainFrame.getFrame().add(records);
                break;
            case HELP:
                mainFrame.getFrame().add(help);
                break;
        }
        mainFrame.getFrame().setVisible(true);
    }
}
