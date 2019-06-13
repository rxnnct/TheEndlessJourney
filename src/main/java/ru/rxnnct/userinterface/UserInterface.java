package ru.rxnnct.userinterface;

/**
 * Access for app
 *
 */
public class UserInterface {
    private MainFrame mainFrame;

    //constructor
    public UserInterface() {
        mainFrame = new MainFrame();
    }

    public void drawMainMenu(){
        MainMenu mainMenu = new MainMenu();
        mainFrame.getFrame().add(mainMenu);
    }

}
