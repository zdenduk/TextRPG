package com.company.domain.impl;

import com.company.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LocationImpl implements Location {

    private List<Option> options;
    private String text;
    private List<Item> items;
    private Item item;

    public LocationImpl(String text) {
        this.options = new ArrayList<>();
        this.text = text;
        this.items = new ArrayList<>();
        this.item = item;
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
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public List<Option> getOptions() {
        return options;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void addOption(String text, Location targetLocation) {
        options.add(new OptionImpl(text, targetLocation));
    }

    @Override
    public void removeOption(Option option) {
        options.remove(option);
    }

    @Override
    public void addOption(String text, Item item) {
        options.add(new OptionImpl(text, item));
    }

    @Override
    public void addOption(String text, Arena arena) {
        options.add(new OptionImpl(text, arena));
    }
}
