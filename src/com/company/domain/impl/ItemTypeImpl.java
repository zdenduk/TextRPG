package com.company.domain.impl;

import com.company.domain.Item;
import com.company.domain.ItemType;

public enum ItemTypeImpl implements ItemType {
    POTION("potion") {},
    WEAPON("weapon") {},
    ARMOR("armor") {};

    private String caption;

    private ItemTypeImpl(String a) {
        this.caption = a;
    }

    @Override
    public String getCaption() {
        return caption;
    }
}
