package com.company.domain.impl;

import com.company.domain.Item;
import com.company.domain.Location;
import com.company.domain.Option;
import com.company.domain.Player;

public class OptionImpl implements Option {

    String text;
    Location location;
    Item item;

    @Override
    public Item getItem() {
        return item;
    }

    Player player;

    public OptionImpl(String text, Location location, Item item, Player player) {
        this.text = text;
        this.location = location;
        this.item = item;
        this.player = player;
    }

    public OptionImpl(String text, Location location) {
        this.text = text;
        this.location = location;
    }

    public OptionImpl(String text, Item item) {
        this.text = text;
        this.item = item;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Location getLocation() {
        return location;
    }


}
