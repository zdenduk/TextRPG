package com.company.domain.impl;

import com.company.domain.Item;
import com.company.domain.ItemType;

public class ItemImpl implements Item {

    String name;
    ItemType type;

    public ItemImpl(String name, ItemType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ItemType getItemType() {
        return type;
    }
}
