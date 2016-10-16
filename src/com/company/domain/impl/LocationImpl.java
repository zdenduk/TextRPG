package com.company.domain.impl;

import com.company.domain.Item;
import com.company.domain.Location;
import com.company.domain.Option;

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
    public void addItem(int durability, int ad, String name) {
        addItem(new ItemImpl(durability, ad, name));
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
}
