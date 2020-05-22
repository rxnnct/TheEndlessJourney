package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MainMenu extends JComponent {

    private final int MENU_ITEMS_LEFT_MARGIN = 200;
    private final int MENU_ITEMS_TOP_MARGIN = 120;
    private final int MENU_ITEMS_TOP_SPACING = 60;
    private final String ASSETS_MENU_PATH = "assets" + File.separator + "menu" + File.separator;

    private MainMenuItems currentMenuItem = MainMenuItems.CONTINUE;
    private ArrayList<Image> menuItems = new ArrayList<>();

    
    //accessors
    public void setMenuItemToNext() {
        this.currentMenuItem = currentMenuItem.getNext();
    }

    public void setMenuItemToPrevious() {
        this.currentMenuItem = currentMenuItem.getPrevious();
    }

    //constructors
    MainMenu() {
        Collections.addAll(menuItems,
                Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "cont1.png"),
                Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "new1.png"),
                Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "rec1.png"),
                Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "about1.png")
        );
    }

    //methods
    public void setImagesToDisabledView(){
        menuItems.set(0, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "cont1.png"));
        menuItems.set(1, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "new1.png"));
        menuItems.set(2, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "rec1.png"));
        menuItems.set(3, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "about1.png"));
    }

    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.MENU) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            setImagesToDisabledView();
            switch (currentMenuItem) {
                case CONTINUE:
                    setImagesToDisabledView();
                    menuItems.set(0, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "cont2.png"));
                    break;
                case NEW_GAME:
                    setImagesToDisabledView();
                    menuItems.set(1, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "new2.png"));
                    break;
                case RECORDS:
                    setImagesToDisabledView();
                    menuItems.set(2, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "rec2.png"));
                    break;
                case HELP:
                    setImagesToDisabledView();
                    menuItems.set(3, Toolkit.getDefaultToolkit().getImage(ASSETS_MENU_PATH + "about2.png"));
                    break;
            }

            int currentMenuItemTopMargin = MENU_ITEMS_TOP_MARGIN;
            for (Image menuItem : menuItems) {
                graphics2d.drawImage(menuItem, MENU_ITEMS_LEFT_MARGIN, currentMenuItemTopMargin, this);
                currentMenuItemTopMargin += MENU_ITEMS_TOP_SPACING;
            }
            super.repaint();
        }
    }

    public void enterPressed(){
        switch(currentMenuItem) {
            case CONTINUE:
                UserInterface.getInstance().changeApplicationState(ApplicationStates.MAP);
                UserInterface.getInstance().drawGameMapUserInterface();
                break;
            case NEW_GAME:
                Application.getInstance().newGame();
                UserInterface.getInstance().changeApplicationState(ApplicationStates.MAP);
                UserInterface.getInstance().drawGameMapUserInterface();
                //begin test output
//                GameMap gameMap = new GameMap();
//                gameMap.generate();
                //end
                break;
            case RECORDS:
                UserInterface.getInstance().changeApplicationState(ApplicationStates.RECORDS);
                break;
            case HELP:
                UserInterface.getInstance().changeApplicationState(ApplicationStates.HELP);
                UserInterface.getInstance().drawHelp();
                break;
        }
        UserInterface.getInstance().changeCurrentFrame();
    }


}