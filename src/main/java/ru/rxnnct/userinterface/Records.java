package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.util.ApplicationFileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Records extends JComponent {

    //methods
    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.RECORDS) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            graphics2d.setPaint(Color.black);
            Font currentFont = graphics2d.getFont();
            graphics2d.setFont(currentFont.deriveFont(currentFont.getSize() * 2.8F));
            graphics2d.drawString("Last records:", 190, 30);;
            int j = 0;
            try {
                ApplicationFileHandler.getInstance().loadScore();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = ApplicationFileHandler.getInstance().getScoreList().size()-1; i >= 0; i--) {
                graphics2d.drawString(ApplicationFileHandler.getInstance().getScoreList().get(i), 190, 70 + 50 * j);
                j++;
            }
            super.repaint();
        }
    }

    public void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().changeCurrentFrame();
    }
}
