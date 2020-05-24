package ru.rxnnct.userinterface;

import ru.rxnnct.application.*;
import ru.rxnnct.application.characters.Enemy;
import ru.rxnnct.application.characters.Player;
import ru.rxnnct.application.util.ApplicationFileHandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameMapUserInterface extends JComponent {
    private final int TILE_SIZE = 50;
    private final String ASSETS_GAME_MAP_PATH = "assets" + File.separator + "map" + File.separator;

    //methods
    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.MAP) {
            Graphics2D graphics2d = (Graphics2D) graphics;
            //Map
            Image tile;
            for (int i = 0; i < Application.getInstance().getCurrentGameMap().getMap().length; i++) {
                for (int j = 0; j < Application.getInstance().getCurrentGameMap().getMap()[0].length; j++) {
                    tile = Toolkit.getDefaultToolkit().getImage(ASSETS_GAME_MAP_PATH + "tile" + (Application.getInstance().getCurrentGameMap().getMap()[i][j] + 1) + ".png");
                    graphics2d.drawImage(tile, TILE_SIZE * j + 3 * TILE_SIZE, TILE_SIZE * i + 1 * TILE_SIZE, this);
                }
            }
            //Enemies
            Image enemySprite = Toolkit.getDefaultToolkit().getImage(ASSETS_GAME_MAP_PATH + "enemy.png");
            for (Enemy enemy : Application.getInstance().getCurrentGameMap().getEnemies()) {
                graphics2d.drawImage(enemySprite, enemy.getCharacterPositionCol() * TILE_SIZE + 3 * TILE_SIZE
                        , enemy.getCharacterPositionRow() * TILE_SIZE + 1 * TILE_SIZE, this);
            }
            //Player
            Image characterSprite = Toolkit.getDefaultToolkit().getImage(ASSETS_GAME_MAP_PATH + "char.png");
            graphics2d.drawImage(characterSprite, Player.getInstance().getCharacterPositionCol() * TILE_SIZE + 3 * TILE_SIZE
                    , Player.getInstance().getCharacterPositionRow() * TILE_SIZE + 1 * TILE_SIZE, this);
            //Info
            graphics2d.setPaint(Color.WHITE);
            Font currentFont = graphics2d.getFont();
            graphics2d.setFont(currentFont.deriveFont(currentFont.getSize() * 2F));
            graphics2d.drawString("Stage: " + Player.getInstance().getCurrentStage() + "   Health: " + Player.getInstance().getCurrentHitPoints()
                    + "   Score: " + Player.getInstance().getScore(), 10, 30);
            super.repaint();
        }
    }

    public void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().drawMainMenu();
        UserInterface.getInstance().changeCurrentFrame();
        try {
            ApplicationFileHandler.getInstance().saveGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upPressed(){
        Player.getInstance().stepUp();
    }

    public void downPressed(){
        Player.getInstance().stepDown();
    }

    public void leftPressed(){
        Player.getInstance().stepLeft();
    }

    public void rightPressed(){
        Player.getInstance().stepRight();
    }


}
