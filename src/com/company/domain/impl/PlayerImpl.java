package com.company.domain.impl;

import com.company.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {

    private String name;
    private int hp;
    private List<Item> items;
    private Location location;
    private List<Option> options;

    WeaponImpl weapon;
    ArmorImpl armor;

    public PlayerImpl(String name, int hp, Location location) {
        this.name = name;
        this.hp = hp;
        this.options = new ArrayList<>();
        this.items = new ArrayList<>();
        this.location = location;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public WeaponImpl getWeapon() {
        return weapon;
    }

    @Override
    public ArmorImpl getArmor() {
        return armor;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void addItem(String name, ItemType type) {
        addItem(new ItemImpl(name, type));
    }

    @Override
    public Location getCurrentLocation() {
        return location;
    }

    @Override
    public void setCurrentLocation(Location location) {
        this.location = location;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public void setWeapon(WeaponImpl weapon) {
        this.weapon = weapon;
    }

    @Override
    public void setArmor(ArmorImpl armor) {
        this.armor = armor;
    }
}
