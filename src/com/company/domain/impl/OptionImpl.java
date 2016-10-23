package com.company.domain.impl;

import com.company.domain.*;

public class OptionImpl implements Option {

    private String text;
    private Location location;
    private Item item;
    private Arena arena;

    @Override
    public Item getItem() {
        return item;
    }

    Player player;

    public OptionImpl(String text, Location location, Item item, Arena arena) {
        this.text = text;
        this.location = location;
        this.item = item;
        this.arena = arena;
    }

    public OptionImpl(String text, Location location) {
        this.text = text;
        this.location = location;
    }

    public OptionImpl(String text, Item item) {
        this.text = text;
        this.item = item;
    }

    public OptionImpl(String text, Arena arena) {
        this.text = text;
        this.arena = arena;
    }


    @Override
    public String getText() {
        return text;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    public Arena getArena() {
        return arena;
    }
}
