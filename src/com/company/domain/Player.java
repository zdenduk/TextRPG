package com.company.domain;

import java.util.List;

public interface Player {
    int getHp();
    String getName();

    Item getWeapon();
    Item getArmor();

    Location getCurrentLocation();
    void setCurrentLocation(Location location);

    List getItems();
    void addItem(Item item);
    void addItem(String name, int durability, int ad);
}
