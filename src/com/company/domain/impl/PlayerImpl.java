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

    Item weapon;
    Item armor;

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
    public Item getWeapon() {
        return weapon;
    }

    @Override
    public Item getArmor() {
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

}
