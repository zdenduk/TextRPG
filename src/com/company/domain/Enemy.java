package com.company.domain;

import com.company.domain.impl.ArmorImpl;
import com.company.domain.impl.WeaponImpl;

import java.util.List;

public interface Enemy {

    int getHp();

    String getName();

    WeaponImpl getWeapon();

    ArmorImpl getArmor();

    List<Item> getItems();

    void addItem(Item item);

    void addItem(String name, ItemType type);

    void removeItem(Item item);

    void setHp(int hp);

    void setWeapon(WeaponImpl weapon);

    void setArmor(ArmorImpl armor);
}
