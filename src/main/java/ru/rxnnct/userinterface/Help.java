package ru.rxnnct.userinterface;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;

import javax.swing.*;
import java.awt.*;

public class Help extends JComponent {

    public void paint(Graphics graphics) {
        if (Application.getInstance().getApplicationState() == ApplicationStates.HELP) {
            Graphics2D graphics2d = (Graphics2D) graphics;

            //Текст:
            graphics2d.setPaint(Color.black);
            Font currentFont = graphics2d.getFont();
            graphics2d.setFont(currentFont.deriveFont(currentFont.getSize() * 1.6F));
            graphics2d.drawString("Управление на карте: стрелки", 30, 25);
            graphics2d.drawString("Управление в бою:", 30, 75);
            graphics2d.drawString("Q: Атака", 30, 100);
            graphics2d.drawString("W: Проникающая атака (игнорирует блок)", 30, 125);
            graphics2d.drawString("E: Жар (враг обжигается, когда атакует)", 30, 150);
            graphics2d.drawString("A: Блок (блокирует все, кроме вытягивания и проникающей атаки)", 30, 175);
            graphics2d.drawString("S: Вытягивание здоровья (крадет часть здоровья)", 30, 200);
            graphics2d.drawString("D: Исцеление", 30, 225);
            graphics2d.drawString("Противники обладают различным поведением во время, которое зависит", 30, 300);
            graphics2d.drawString("от типа его владельца. На каждом следующем уровне здоровье противников", 30, 325);
            graphics2d.drawString("увеличивается, а ваше - восстанавливается. Кроме того, количество", 30, 350);
            graphics2d.drawString("очков за победы с каждым уровнем растет. Учитывайте это во время путешествия.", 30, 375);
            graphics2d.drawString("ESC: выйти в меню", 30, 525);

            super.repaint();
        }
    }

    public static void escPressed(){
        Application.getInstance().setApplicationState(ApplicationStates.MENU);
        UserInterface.getInstance().changeCurrentFrame();
    }
}
