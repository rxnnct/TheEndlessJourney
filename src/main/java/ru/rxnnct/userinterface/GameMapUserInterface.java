package ru.rxnnct.userinterface;

import ru.rxnnct.application.*;

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
        //todo: save game
    }

    public void upPressed(){
        if (Player.getInstance().getCharacterPositionRow() != 0){
            switch (Application.getInstance().getCurrentGameMap().getMap()[Player.getInstance().getCharacterPositionRow() - 1][Player.getInstance().getCharacterPositionCol()]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    Player.getInstance().changeCharacterPositionRow(-1);
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                    //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

    public void downPressed(){
        if (Player.getInstance().getCharacterPositionRow() != GameMap.MAP_SIZE_ROWS - 1){
            switch (Application.getInstance().getCurrentGameMap().getMap()[Player.getInstance().getCharacterPositionRow() + 1][Player.getInstance().getCharacterPositionCol()]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    Player.getInstance().changeCharacterPositionRow(1);
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

    public void leftPressed(){
        if (Player.getInstance().getCharacterPositionCol() != 0){
            switch (Application.getInstance().getCurrentGameMap().getMap()[Player.getInstance().getCharacterPositionRow()][Player.getInstance().getCharacterPositionCol() - 1]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    Player.getInstance().changeCharacterPositionCol(-1);
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }

    public void rightPressed(){
        if (Player.getInstance().getCharacterPositionCol() != GameMap.MAP_SIZE_COLS - 1){
            switch (Application.getInstance().getCurrentGameMap().getMap()[Player.getInstance().getCharacterPositionRow()][Player.getInstance().getCharacterPositionCol() + 1]){
                case GameMap.MAP_FIELD_CORRIDOR:
                    Player.getInstance().changeCharacterPositionCol(1);
                    break;
                case GameMap.MAP_FIELD_EXIT:
                    //todo: new stage --- old diploma version: ProgressMethods.newFloor();
                    break;
                //todo: enemies
//                case 3:
//                    Player.getInstance().changeCharacterPositionRow(-1);
//                    ApplicationStates.progressState.mapArray[ApplicationStates.progressState.characterPositionI][ApplicationStates.progressState.characterPositionJ] = 1;
//                    GameBattle.enemy.initialize();
//                    ApplicationStates.currentActivity = 2;
//                    MainWindow.execute();
//                    break;
            }
        }
    }


}
