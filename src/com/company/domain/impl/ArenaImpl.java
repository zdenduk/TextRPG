package com.company.domain.impl;

import com.company.domain.Arena;
import com.company.domain.Enemy;
import com.company.domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaImpl implements Arena {

    private Enemy enemy;
    private List<Enemy> enemies;

    public ArenaImpl() {
        this.enemies = new ArrayList<>();
    }

    @Override
    public void turn(Player player, Enemy enemy) {
        /* calculate hp loss for each participant in battle */
        int playerLoseHp = 0;
        int enemyLoseHp = 0;

        boolean playerCriticalStrike = critPlayer();
        boolean enemyCriticalStrike = critEnemy();

        if (playerCriticalStrike) {
            playerLoseHp = (int) Math.ceil((enemy.getWeapon().getAttackVal() / player.getArmor().getArmorVal()));
            enemyLoseHp = (int) (Math.ceil((player.getWeapon().getAttackVal()) / enemy.getArmor().getArmorVal())) * 2;
            System.out.println("Enemy did a critical strike.");
        } else if (enemyCriticalStrike) {
            playerLoseHp = (int) (Math.ceil((enemy.getWeapon().getAttackVal() / player.getArmor().getArmorVal()))) * 2;
            enemyLoseHp = (int) Math.ceil((player.getWeapon().getAttackVal()) / enemy.getArmor().getArmorVal());
            System.out.println("Yes! A critical strike!");
        }
        else if(playerCriticalStrike && enemyCriticalStrike){
            playerLoseHp = (int) (Math.ceil((enemy.getWeapon().getAttackVal() / player.getArmor().getArmorVal()))) * 2;
            enemyLoseHp = (int) (Math.ceil((player.getWeapon().getAttackVal()) / enemy.getArmor().getArmorVal()))*2;
            System.out.println("We both managed to do a big amount of damage.");
        }
        else {
            playerLoseHp = (int) Math.ceil((enemy.getWeapon().getAttackVal() / player.getArmor().getArmorVal()));
            enemyLoseHp = (int) Math.ceil((player.getWeapon().getAttackVal()) / enemy.getArmor().getArmorVal());
        }
        player.setHp(player.getHp() - playerLoseHp);
        enemy.setHp(enemy.getHp() - enemyLoseHp);

        System.out.println("I lost " + playerLoseHp + " HP and I damaged enemy for " + enemyLoseHp + " HP");
        if (player.getHp() <= 0) {
            System.out.println("Aaaaaaaaaaaaaaaaah");
        } else if (enemy.getHp() <= 0) {
            System.out.println("I defeated " + enemy.getName());
        } else {
            turn(player, enemy);
        }
    }

    @Override
    public boolean critPlayer() {
        Random r = new Random();
        if ((r.nextInt(100) + 1) > 50) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean critEnemy() {
        Random r = new Random();
        if ((r.nextInt(100) + 1) > 50) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    @Override
    public List<Enemy> getEnemies() {
        return enemies;
    }
}
