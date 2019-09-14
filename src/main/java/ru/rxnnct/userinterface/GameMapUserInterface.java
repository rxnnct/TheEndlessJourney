package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.Player;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GameMapUserInterface extends JComponent {
    private final int TILE_SIZE = 50;
    private final String ASSETS_GAME_MAP_PATH = "assets" + File.separator + "map" + File.separator;

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

            //Player
            Image characterSprite = Toolkit.getDefaultToolkit().getImage(ASSETS_GAME_MAP_PATH + "char.png");
            graphics2d.drawImage(characterSprite, Player.getInstance().getCharacterPositionCol() * TILE_SIZE + 3 * TILE_SIZE
                    , Player.getInstance().getCharacterPositionRow() * TILE_SIZE + 1 * TILE_SIZE, this);
            super.repaint();
        }
    }

    public static void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().drawMainMenu();
        UserInterface.getInstance().changeCurrentFrame();

    }
}
