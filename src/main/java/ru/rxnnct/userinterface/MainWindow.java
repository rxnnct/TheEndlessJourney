package ru.rxnnct.userinterface;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private String WINDOW_TITLE = "The Endless Journey";
    private int WINDOW_WIDTH = 800;
    private int WINDOW_HEIGHT = 600;

    private JFrame window = new JFrame(WINDOW_TITLE);

    public void newWindow() {
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout(1, 1));
        window.setResizable(false);
        window.setVisible(true);
    }

}
