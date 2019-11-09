package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.Enemy;
import ru.rxnnct.application.Player;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BattleUserInterface extends JComponent {

    private final String ASSETS_BATTLE_PATH = "assets" + File.separator + "effects" + File.separator;

    //methods
    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.BATTLE) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            //background
            Image background = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_PATH + "background.png");
            graphics2d.drawImage(background, 0, 0, this);


            super.repaint();
        }
    }

}
