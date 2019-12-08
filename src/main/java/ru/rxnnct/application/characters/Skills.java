package ru.rxnnct.application.characters;

import ru.rxnnct.application.ApplicationStates;

import java.io.IOException;

public class Skills {
//    GameCharacter skillSubject;
//    GameCharacter skillObject;
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

    //todo: new states for GameCharacter
    public void execute(GameCharacter skillSubject, GameCharacter skillObject){
        if ((!currentCoolDown && !skillSubject.blockState) && !skillSubject.castState){
            new Thread(() -> {
                try {
                    skillSubject.castState = true;
                    Thread.sleep(castTime);
                    skillSubject.castState = false;
                    if (healingPower > 0) {
                        if (skillSubject.currentHitPoints + healingPower >= skillSubject.maximumHitPoints) {
                            skillSubject.currentHitPoints = skillSubject.maximumHitPoints;
                        } else {
                            skillSubject.currentHitPoints = skillSubject.currentHitPoints + healingPower;
                        }
                        new Thread(() -> {
                            try {
                                skillSubject.healEffect = true;
                                Thread.sleep(300);
                                skillSubject.healEffect = false;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }

                    //todo: other skill effects
                    //-------------------------

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
