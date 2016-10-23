package com.company.domain.impl;

import com.company.domain.ItemType;

public class ArmorImpl extends ItemImpl {

    public ArmorImpl(String name, ItemType type, int armorNumber) {
        super(name, ItemType.ARMOR);
        this.armorNumber = armorNumber;
    }

    private int armorNumber;

    public int getArmorVal() {
        return armorNumber;
    }

}
