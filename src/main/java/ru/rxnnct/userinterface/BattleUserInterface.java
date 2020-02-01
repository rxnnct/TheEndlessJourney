package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.characters.EnemyTypes;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.application.characters.Skill;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BattleUserInterface extends JComponent {

    private final String ASSETS_BATTLE_EFFECTS_PATH = "assets" + File.separator + "effects" + File.separator;
    private final String ASSETS_BATTLE_SKILLICONS_PATH = "assets" + File.separator + "skillicons" + File.separator;
    private final String ASSETS_BATTLE_CHARACTERS_PATH = "assets" + File.separator + "characters" + File.separator;
    private Image skillIcon;

    //methods
    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.BATTLE) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            //background
            Image background = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_EFFECTS_PATH + "background.png");
            graphics2d.drawImage(background, 0, 0, this);
            //skill icons
            //todo: make cycle and collection for skills in GameCharacter
            addSkillIcon("hit", Player.getInstance().getHit(), 250, 250, graphics2d);
            addSkillIcon("penetrate", Player.getInstance().getPenetrate(), 350, 250, graphics2d);
            addSkillIcon("reflect", Player.getInstance().getReflect(), 450, 250, graphics2d);
            addSkillIcon("block", Player.getInstance().getBlock(), 250, 150, graphics2d);
            addSkillIcon("leech", Player.getInstance().getLeech(), 350, 150, graphics2d);
            addSkillIcon("heal", Player.getInstance().getHeal(), 450, 150, graphics2d);
            //text
            graphics2d.setPaint(Color.black);
            Font currentFont = graphics2d.getFont();
            graphics2d.setFont(currentFont.deriveFont(currentFont.getSize() * 3.5F));
            graphics2d.drawString("+ " + Player.getInstance().getCurrentHitPoints(), 70, 430);
            graphics2d.drawString(Application.getInstance().getCurrentBattle().getEnemy().getCurrentHitPoints() + " +", 630, 430);

            //characters
            graphics2d.drawImage(Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_CHARACTERS_PATH + "player.png"), 100, 100, this);
            String enemyCharacterImagePath = ASSETS_BATTLE_CHARACTERS_PATH + "enemy" + Application.getInstance().getCurrentBattle().getEnemy().getEnemyTypeNumber() + ".png";
            graphics2d.drawImage(Toolkit.getDefaultToolkit().getImage(enemyCharacterImagePath), UserInterface.getInstance().getMainFrame().getFRAME_WIDTH() - 200, 100, this);

            super.repaint();
        }
    }

    public void addSkillIcon(String iconName, Skill skill, int leftPadding, int bottomPadding, Graphics2D graphics2d){
        skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + iconName + skill.getAvailability() + ".png");
        graphics2d.drawImage(skillIcon, leftPadding, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - bottomPadding, this);
    }
}
