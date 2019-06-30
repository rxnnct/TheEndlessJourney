package ru.rxnnct.userinterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainMenu extends JComponent {

    private MainMenuItems currentMenuItem = MainMenuItems.CONTINUE;
    Image menuItemContinue;
    Image menuItemNewGame;
    Image menuItemRecords;
    Image menuItemHelp;

    //accessors
    public void setMenuItemToNext() {
        this.currentMenuItem = currentMenuItem.getNext();
    }

    public void setMenuItemToPrevious() {
        this.currentMenuItem = currentMenuItem.getPrevious();
    }

    //methods
    public void setImagesToDisabledView(){
        menuItemContinue = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "cont1.png");
        menuItemNewGame = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "new1.png");
        menuItemRecords = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "rec1.png");
        menuItemHelp = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "about1.png");
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;
        setImagesToDisabledView();
        switch (currentMenuItem) {
            case CONTINUE:
                setImagesToDisabledView();
                menuItemContinue = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "cont2.png");
                break;
            case NEW_GAME:
                setImagesToDisabledView();
                menuItemNewGame = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "new2.png");
                break;
            case RECORDS:
                setImagesToDisabledView();
                menuItemRecords = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "rec2.png");
                break;
            case HELP:
                setImagesToDisabledView();
                menuItemHelp = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "about2.png");
                break;
        }
        graphics2d.drawImage(menuItemContinue, 200, 120, this);
        graphics2d.drawImage(menuItemNewGame, 200, 180, this);
        graphics2d.drawImage(menuItemRecords, 200, 240, this);
        graphics2d.drawImage(menuItemHelp, 200, 300, this);

        super.repaint();
    }



}
