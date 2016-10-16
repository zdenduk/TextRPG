package com.company.domain;

import java.util.List;

public interface Player {
    int getHp();
    String getName();

    Item getWeapon();
    Item getArmor();

    Location getCurrentLocation();
    void setCurrentLocation(Location location);

    List<Item> getItems();
    void addItem(Item item);
    void addItem(String name, ItemType type);
}
