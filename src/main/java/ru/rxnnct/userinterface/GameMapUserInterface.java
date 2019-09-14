package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.Player;

import javax.swing.*;
import java.awt.*;

public class GameMapUserInterface extends JComponent {
    private final int TILE_SIZE = 50;

    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.MAP) {
            Graphics2D graphics2d = (Graphics2D) graphics;



            //Map
            Image tile;
            for (int i = 0; i < Application.getInstance().getCurrentGameMap().getMap().length; i++) {
                for (int j = 0; j < Application.getInstance().getCurrentGameMap().getMap()[0].length; j++) {
                    tile = Toolkit.getDefaultToolkit().getImage("assets\\map\\tile"+ (Application.getInstance().getCurrentGameMap().getMap()[i][j] + 1) + ".png");
                    graphics2d.drawImage(tile, TILE_SIZE * j + 3 * TILE_SIZE, TILE_SIZE * i + 1 * TILE_SIZE, this);
                }
            }

            //todo: MAKE VISIBLE
            //Player
            Image characterSprite = Toolkit.getDefaultToolkit().getImage("assets\\map\\char.png");
            graphics2d.drawImage(characterSprite, Player.getInstance().getCharacterPositionCol() * TILE_SIZE + 3 * TILE_SIZE
                    , Player.getInstance().getCharacterPositionRow() * TILE_SIZE + 1 * TILE_SIZE, this);
            super.repaint();
        }
    }

    public static void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().changeCurrentFrame();
    }
}
