package ru.rxnnct.userinterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainMenu extends JComponent {
    private MainMenuItems currentMenuItem = MainMenuItems.NEW_GAME;
    Image menuItemContinue;
    Image menuItemNewGame;
    Image menuItemRecords;
    Image menuItemHelp;

    public void setImagesToDisabledView(){
        menuItemContinue = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "cont1.png");
        menuItemNewGame = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "new1.png");
        menuItemRecords = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "rec1.png");
        menuItemHelp = Toolkit.getDefaultToolkit().getImage("assets" + File.separator + "menu" + File.separator + "about1.png");
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //Фон:
        //frame.getContentPane().setBackground(Color.white);


        //Меню:
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
        g2.drawImage(menuItemContinue, 200, 120, this);
        g2.drawImage(menuItemNewGame, 200, 180, this);
        g2.drawImage(menuItemRecords, 200, 240, this);
        g2.drawImage(menuItemHelp, 200, 300, this);

        super.repaint();
    }

}
