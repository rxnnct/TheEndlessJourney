package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MainFrame {
    private String FRAME_TITLE = "The Endless Journey";
    private int FRAME_WIDTH = 800;
    private int FRAME_HEIGHT = 600;

    private JFrame frame;

    //constructor
    MainFrame() {
        setFrame();
    }

    //accessors
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public int getFRAME_HEIGHT() {
        return FRAME_HEIGHT;
    }

    public int getFRAME_WIDTH() {
        return FRAME_WIDTH;
    }

    //methods
    private void setFrame(){
        frame = new JFrame(FRAME_TITLE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout(1, 1));
        frame.setResizable(false);
        frame.setVisible(true);
        setKeyAdapter();
    }

    private void setKeyAdapter(){
        frame.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent event) {
                int keyCode = event.getKeyCode();

                if (Application.getInstance().getApplicationState() == ApplicationStates.MENU) {
                    switch (keyCode) {
                        case KeyEvent.VK_UP:
                            UserInterface.getInstance()
                                    .getMainMenu()
                                    .setMenuItemToPrevious();
                            break;
                        case KeyEvent.VK_DOWN:
                            UserInterface.getInstance()
                                    .getMainMenu()
                                    .setMenuItemToNext();
                            break;
                        case KeyEvent.VK_ENTER:
                            UserInterface.getInstance()
                                    .getMainMenu()
                                    .enterPressed();
                            break;
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.MAP) {
                    switch (keyCode) {
                        case KeyEvent.VK_ESCAPE:
                            UserInterface.getInstance()
                                    .getGameMapUserInterface()
                                    .escPressed();
                            break;
                        case KeyEvent.VK_UP:
                            UserInterface.getInstance()
                                    .getGameMapUserInterface()
                                    .upPressed();
                            break;
                        case KeyEvent.VK_DOWN:
                            UserInterface.getInstance()
                                    .getGameMapUserInterface()
                                    .downPressed();
                            break;
                        case KeyEvent.VK_LEFT:
                            UserInterface.getInstance()
                                    .getGameMapUserInterface()
                                    .leftPressed();
                            break;
                        case KeyEvent.VK_RIGHT:
                            UserInterface.getInstance()
                                    .getGameMapUserInterface()
                                    .rightPressed();
                            break;
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.BATTLE) {
                    switch (keyCode) {
                        case KeyEvent.VK_Q:
                            UserInterface.getInstance()
                                    .getBattleUserInterface()
                                    .qPressed();
                            break;
                        case KeyEvent.VK_W:
                            UserInterface.getInstance()
                                    .getBattleUserInterface()
                                    .wPressed();
                            break;
                        case KeyEvent.VK_E:
                            UserInterface.getInstance()
                                    .getBattleUserInterface()
                                    .ePressed();
                            break;
                        case KeyEvent.VK_A:
                            UserInterface.getInstance()
                                    .getBattleUserInterface()
                                    .aPressed();
                            break;
                        case KeyEvent.VK_S:
                            UserInterface.getInstance()
                                    .getBattleUserInterface()
                                    .sPressed();
                            break;
                        case KeyEvent.VK_D:
                            UserInterface.getInstance()
                                    .getBattleUserInterface()
                                    .dPressed();
                            break;
                    }
                }


                if (Application.getInstance().getApplicationState() == ApplicationStates.RECORDS) {
                    switch (keyCode) {
                        case KeyEvent.VK_ESCAPE:
                            UserInterface.getInstance()
                                    .getRecords()
                                    .escPressed();
                            break;
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.HELP) {
                    switch (keyCode) {
                        case KeyEvent.VK_ESCAPE:
                            UserInterface.getInstance()
                                    .getHelp()
                                    .escPressed();
                            break;
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.GAME_OVER) {
                    switch (keyCode) {
                        case KeyEvent.VK_ESCAPE:
                            UserInterface.getInstance()
                                    .getGameOver()
                                    .escPressed();
                            break;
                    }
                }
            }
        });
    }

}
