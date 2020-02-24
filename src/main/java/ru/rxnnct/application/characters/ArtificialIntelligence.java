package ru.rxnnct.application.characters;

import ru.rxnnct.application.Application;
import ru.rxnnct.application.ApplicationStates;
import ru.rxnnct.application.util.RandomGenerator;

public class ArtificialIntelligence {
    private double hitPriorityRate;
    private double blockPriorityRate;
    private double healPriorityRate;
    private double leechPriorityRate;
    private double penetratePriorityRate;
    private double reflectPriorityRate;
    private int[][] priorityArray = new int[2][6];
    private Enemy enemy;
    private int priorityAdd;

    public ArtificialIntelligence(Enemy enemy){
        this.enemy = enemy;
        switch (enemy.getEnemyType()){
            case FANATIC:
                this.hitPriorityRate = 1;
                this.blockPriorityRate = 0.5;
                this.healPriorityRate = 0.5;
                this.leechPriorityRate = 1.5;
                this.penetratePriorityRate = 1.5;
                this.reflectPriorityRate = 1;
                break;
            case NORMAL:
                this.hitPriorityRate = 1.5;
                this.blockPriorityRate = 1;
                this.healPriorityRate = 1;
                this.leechPriorityRate = 0.5;
                this.penetratePriorityRate = 1.5;
                this.reflectPriorityRate = 0.5;
                break;
            case GUARDIAN:
                this.hitPriorityRate = 1;
                this.blockPriorityRate = 1.5;
                this.healPriorityRate = 1.5;
                this.leechPriorityRate = 0.5;
                this.penetratePriorityRate = 0.5;
                this.reflectPriorityRate = 1;
                break;
        }
        for (int i = 0; i < 6; i++) {
            this.priorityArray[0][i] = 200; //start value
            this.priorityArray[1][i] = 300; //max value
        }
    }

    public void start(){
        new Thread(() -> {
            while (Application.getInstance().getApplicationState() == ApplicationStates.BATTLE){
                if (enemy.currentHitPoints > Math.round(enemy.currentHitPoints * 0.66)) priorityAdd = 5;
                priorityArray[0][0] = priorityArray[0][0] + (int) Math.round(hitPriorityRate * RandomGenerator.getInstance().nextInt(7 + priorityAdd));
                priorityAdd = 0;
                if (priorityArray[0][0] >= priorityArray[1][0]){
                    enemy.getHit().execute(enemy, Player.getInstance());
                    priorityArray[0][0] = 0;
                }

            }
        }).start();
    }
}
