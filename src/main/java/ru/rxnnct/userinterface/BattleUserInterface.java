package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.characters.Player;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BattleUserInterface extends JComponent {

    private final String ASSETS_BATTLE_EFFECTS_PATH = "assets" + File.separator + "effects" + File.separator;
    private final String ASSETS_BATTLE_SKILLICONS_PATH = "assets" + File.separator + "skillicons" + File.separator;
    private Image skillIcon;

    //methods
    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.BATTLE) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            //background
            Image background = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_EFFECTS_PATH + "background.png");
            graphics2d.drawImage(background, 0, 0, this);
            //skill icons
            //todo: make cycle
            skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + "hit" + Player.getInstance().getHit().getAvailability() + ".png");
            graphics2d.drawImage(skillIcon, 250, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - 250, this);
            skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + "penetrate" + Player.getInstance().getHit().getAvailability() + ".png");
            graphics2d.drawImage(skillIcon, 350, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - 250, this);
            skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + "reflect" + Player.getInstance().getHit().getAvailability() + ".png");
            graphics2d.drawImage(skillIcon, 450, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - 250, this);
            skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + "block" + Player.getInstance().getHit().getAvailability() + ".png");
            graphics2d.drawImage(skillIcon, 250, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - 150, this);
            skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + "leech" + Player.getInstance().getHit().getAvailability() + ".png");
            graphics2d.drawImage(skillIcon, 350, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - 150, this);
            skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + "heal" + Player.getInstance().getHit().getAvailability() + ".png");
            graphics2d.drawImage(skillIcon, 450, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - 150, this);

            //text


            super.repaint();
        }
    }

}
