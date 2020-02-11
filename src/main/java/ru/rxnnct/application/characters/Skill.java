package ru.rxnnct.application.characters;

import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.util.RandomGenerator;

import java.io.IOException;

public class Skill {
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
    private boolean penetration;
    private boolean currentCoolDown = false;

    //constructors
    public Skill(int timeToReflect, int reflectTime, int reflectDamage, int coolDown, int blockTime, int castTime, int healingPower, int damage, boolean penetration){
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

    //accessors
    public boolean isCurrentCoolDown() {
        return currentCoolDown;
    }

    public void execute(GameCharacter skillSubject, GameCharacter skillObject){
        if ((!currentCoolDown && !skillSubject.blockState) && !skillSubject.castState){
            new Thread(() -> {
                try {
                    skillSubject.castState = true;
                    Thread.sleep(castTime);
                    skillSubject.castState = false;
                    //healing:
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
                    //dealing damage:
                    if (damage > 0) {
                        if (!skillObject.blockState || penetration) {
                            skillObject.currentHitPoints = skillObject.currentHitPoints - damage + RandomGenerator.getInstance().nextInt((int)Math.round(damage * 0.1 + 1)) - (int)Math.round(damage * 0.1 / 2);
                            new Thread(() -> {
                                try {
                                    skillSubject.damageEffect = true;
                                    Thread.sleep(200);
                                    skillSubject.damageEffect = false;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }).start();
                            if (skillObject.currentHitPoints <= 0) {
                                //todo: next or game over
//                                try {
//                                    util....saveLast();
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                                ApplicationStates.... = MAP/GAME_OVER;
//                                MainFrame. ...();
                            }
                        }
                    }
                    //reflection by enemy:
                    if (skillObject.reflectState){
                        skillSubject.currentHitPoints = skillSubject.currentHitPoints - skillObject.reflectPower
                                + RandomGenerator.getInstance().nextInt((int)Math.round(skillObject.reflectPower * 0.2 + 1)) - (int)Math.round(skillObject.reflectPower * 0.2 / 2);
                        if (skillSubject.currentHitPoints <= 0){
//                            //todo: next or game over
//                            //points;
//                            to menu/etc;
                            //saving
//                            try {
//                                ProgressMethods.saveLast();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            //reflection
            if (reflectTime > 0){
                new Thread(() -> {
                    try {
                        Thread.sleep(timeToReflect);
                        skillSubject.reflectState = true;
                        skillSubject.reflectPower = reflectDamage;
                        Thread.sleep(reflectTime);
                        skillSubject.reflectState = false;
                        skillSubject.reflectPower = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            //block
            if (blockTime > 0){
                new Thread(() -> {
                    try {
                        skillSubject.blockState = true;
                        Thread.sleep(blockTime);
                        skillSubject.blockState = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
            currentCoolDown = true;
            new Thread(() -> {
                try {
                    Thread.sleep(coolDown);
                    currentCoolDown = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public String getAvailability(){
        if (!currentCoolDown && (!Player.getInstance().isBlockState() && !Player.getInstance().isCastState())){
            return "1";
        } else
            return "2";
    }
}
