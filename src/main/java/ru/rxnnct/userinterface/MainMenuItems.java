package ru.rxnnct.userinterface;

public enum MainMenuItems {
    CONTINUE,
    NEW_GAME,
    RECORDS,
    HELP;

    //methods
    public MainMenuItems getNext() {
        return values()[(ordinal() + 1) % values().length];
    }

    public MainMenuItems getPrevious() {
        return values()[(this.ordinal() + values().length - 1) % values().length];
    }
}
