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
                            if (UserInterface.getInstance().getMainMenu().getCurrentMenuItem() == MainMenuItems.CONTINUE){
                                UserInterface.getInstance().getMainMenu().setCurrentMenuItem(MainMenuItems.HELP);
                            } else {
                                UserInterface.getInstance().getMainMenu().setCurrentMenuItem(MainMenuItems.NEW_GAME);
                            }
                            break;
//                        case KeyEvent.VK_DOWN:
//                            if (MainMenu.menuItem == 3){
//                                MainMenu.menuItem = 0;
//                            } else {
//                                MainMenu.menuItem++;
//                            }
//                            break;
//                        case KeyEvent.VK_ENTER:
//                            try {
//                                MainMenu.enterPressed();
//                            } catch (IOException e1) {
//                                e1.printStackTrace();
//                            }
//                            break;
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.MAP) {
                    switch (keyCode) {
                        //
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.BATTLE) {
                    switch (keyCode) {
                        //
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.GAME_OVER) {
                    switch (keyCode) {
                        //
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.RECORDS) {
                    switch (keyCode) {
                        //
                    }
                }

                if (Application.getInstance().getApplicationState() == ApplicationStates.HELP) {
                    switch (keyCode) {
                        //
                    }
                }
            }
        });
    }


}
