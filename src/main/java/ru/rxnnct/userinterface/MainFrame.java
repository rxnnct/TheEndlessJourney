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
        setFrame();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private void setFrame(){
        frame = new JFrame(FRAME_TITLE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new BorderLayout(1, 1));
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
