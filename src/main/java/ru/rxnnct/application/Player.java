package ru.rxnnct.application;

public class Player extends GameCharacter  {
    private static Player ourInstance = new Player();

    public static Player getInstance() {
        return ourInstance;
    }

    private Player() {
    }
}
