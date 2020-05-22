package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.characters.Player;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JComponent {
    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.GAME_OVER) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.setPaint(Color.black);
            Font currentFont = graphics2d.getFont();
            graphics2d.setFont(currentFont.deriveFont(currentFont.getSize() * 3.5F));
            graphics2d.drawString("The journey is over", 200, 200);
            graphics2d.drawString("Total score: " + Player.getInstance().getScore(), 250, 300);

            super.repaint();
        }
    }

    public void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().changeCurrentFrame();
    }
}
