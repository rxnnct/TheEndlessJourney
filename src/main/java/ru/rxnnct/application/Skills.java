package ru.rxnnct.application;

public class Skills {
    private int timeToReflect;
    private int reflectTime;
    private int reflectDamage;
    private int coolDown;
    private int blockTime;
    private int castTime;
    private int healingPower;
    private int damage;
    boolean penetration;
    boolean currentCoolDown = false;

    public Skills(int timeToReflect,int reflectTime, int reflectDamage, int coolDown, int blockTime, int castTime, int healingPower, int damage, boolean penetration){
        this.timeToReflect = timeToReflect;
        this.reflectTime = reflectTime;
        this.reflectDamage = reflectDamage;
        this.coolDown = coolDown;
        this.blockTime = blockTime;
        this.castTime = castTime;
        this.healingPower = healingPower;
        this.damage = damage;
        this.penetration = penetration;
    }

    public void execute(){

    }
}
