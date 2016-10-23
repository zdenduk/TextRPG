package com.company.domain;

import java.util.List;

public interface Arena {

    void turn(Player player, Enemy enemy);

    boolean critPlayer();

    boolean critEnemy();

    void addEnemy(Enemy enemy);

    List<Enemy> getEnemies();

}
