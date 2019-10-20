package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import javax.swing.*;
import java.awt.*;

public class Help extends JComponent {
    private final int TEXT_LEFT_MARGIN = 30;

    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.HELP) {
            Graphics2D graphics2d = (Graphics2D) graphics;

            //Text
            graphics2d.setPaint(Color.black);
            Font currentFont = graphics2d.getFont();
            graphics2d.setFont(currentFont.deriveFont(currentFont.getSize() * 1.6F));
            graphics2d.drawString("Map controls: arrow keys", TEXT_LEFT_MARGIN, 25);
            graphics2d.drawString("Battle controls:", TEXT_LEFT_MARGIN, 75);
            graphics2d.drawString("Q: Simple attack spell", TEXT_LEFT_MARGIN, 100);
            graphics2d.drawString("W: Piercing attack spell (ignores blocking)", TEXT_LEFT_MARGIN, 125);
            graphics2d.drawString("E: Attack spell with self-burning (the enemy burns when he attacks)", TEXT_LEFT_MARGIN, 150);
            graphics2d.drawString("A: Blocking spell", TEXT_LEFT_MARGIN, 175);
            graphics2d.drawString("S: Health drain (ignores blocking and drains health)", TEXT_LEFT_MARGIN, 200);
            graphics2d.drawString("D: Heal", TEXT_LEFT_MARGIN, 225);
            graphics2d.drawString("Opponents have different behavior, which depends ", TEXT_LEFT_MARGIN, 300);
            graphics2d.drawString("on the type of opponent. Each new level restores your health and ", TEXT_LEFT_MARGIN, 325);
            graphics2d.drawString("increases the health of opponents. The number of points ", TEXT_LEFT_MARGIN, 350);
            graphics2d.drawString("for the victory over the enemy is growing at each level.", TEXT_LEFT_MARGIN, 375);
            graphics2d.drawString("ESC: exit to main menu.", TEXT_LEFT_MARGIN, 525);

            super.repaint();
        }
    }

    public void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().changeCurrentFrame();
    }
}
