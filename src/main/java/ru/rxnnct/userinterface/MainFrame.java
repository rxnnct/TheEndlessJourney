package ru.rxnnct.userinterface;

import javax.swing.*;
import java.awt.*;

class MainFrame {
    private String FRAME_TITLE = "The Endless Journey";
    private int FRAME_WIDTH = 800;
    private int FRAME_HEIGHT = 600;
    private JFrame frame;

    //constructor
    MainFrame() {
        this.frame = new JFrame(FRAME_TITLE);
        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout(1, 1));
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

}
