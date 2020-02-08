package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
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
            //todo: mb move to fields:
            Graphics2D graphics2d = (Graphics2D) graphics;
            //background
            Image background = getImage(ASSETS_BATTLE_EFFECTS_PATH, "background.png");
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
            String enemyCharacterImagePath;
            enemyCharacterImagePath = ASSETS_BATTLE_CHARACTERS_PATH + "player.png";
            graphics2d.drawImage(getImage(enemyCharacterImagePath), 100, 100, this);
            enemyCharacterImagePath = ASSETS_BATTLE_CHARACTERS_PATH + "enemy" + Application.getInstance().getCurrentBattle().getEnemy().getEnemyTypeNumber() + ".png";
            graphics2d.drawImage(getImage(enemyCharacterImagePath), UserInterface.getInstance().getMainFrame().getFRAME_WIDTH() - 200, 100, this);
            //Effects
            if (Player.getInstance().isCastState()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "cast.png"), 100, 20, this);
            }
            if (Application.getInstance().getCurrentBattle().getEnemy().isCastState()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "cast.png"), UserInterface.getInstance().getMainFrame().getFRAME_WIDTH() - 100, 20, -100, 100, this);
            }
            if (Player.getInstance().isBlockState()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "block.png"), 100, 100, this);
            }
            if (Application.getInstance().getCurrentBattle().getEnemy().isBlockState()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "block.png"), UserInterface.getInstance().getMainFrame().getFRAME_WIDTH() - 100, 100, -100, 200, this);
            }
            if (Player.getInstance().isDamageEffect()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "damage.png"), 200, 120, this);
            }
            if (Application.getInstance().getCurrentBattle().getEnemy().isDamageEffect()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "damage.png"), UserInterface.getInstance().getMainFrame().getFRAME_WIDTH() - 200, 120, -400, 100, this);
            }
            if (Player.getInstance().isHealEffect()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "heal.png"), 100, 100, this);
            }
            if (Application.getInstance().getCurrentBattle().getEnemy().isHealEffect()){
                graphics2d.drawImage(getImage(ASSETS_BATTLE_EFFECTS_PATH, "heal.png"), UserInterface.getInstance().getMainFrame().getFRAME_WIDTH() - 100, 100, -100, 200, this);
            }
            super.repaint();
        }
    }

    public void qPressed(){
        Player.getInstance().getHit().execute(Player.getInstance(), Application.getInstance().getCurrentBattle().getEnemy());
    }

    public void wPressed(){
        Player.getInstance().getPenetrate().execute(Player.getInstance(), Application.getInstance().getCurrentBattle().getEnemy());
    }

    public void ePressed(){
        Player.getInstance().getReflect().execute(Player.getInstance(), Application.getInstance().getCurrentBattle().getEnemy());
    }

    public void aPressed(){
        Player.getInstance().getBlock().execute(Player.getInstance(), Application.getInstance().getCurrentBattle().getEnemy());
    }

    public void sPressed(){
        Player.getInstance().getLeech().execute(Player.getInstance(), Application.getInstance().getCurrentBattle().getEnemy());
    }

    public void dPressed(){
        Player.getInstance().getHeal().execute(Player.getInstance(), Application.getInstance().getCurrentBattle().getEnemy());
    }

    private void addSkillIcon(String iconName, Skill skill, int leftPadding, int bottomPadding, Graphics2D graphics2d){
        skillIcon = Toolkit.getDefaultToolkit().getImage(ASSETS_BATTLE_SKILLICONS_PATH + iconName + skill.getAvailability() + ".png");
        graphics2d.drawImage(skillIcon, leftPadding, UserInterface.getInstance().getMainFrame().getFRAME_HEIGHT() - bottomPadding, this);
    }

    private Image getImage(String filePath){
        return Toolkit.getDefaultToolkit().getImage(filePath);
    }

    private Image getImage(String fileDirectory, String fileName){
        return Toolkit.getDefaultToolkit().getImage(fileDirectory + fileName);
    }

}
