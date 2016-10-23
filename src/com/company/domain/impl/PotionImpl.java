package com.company.domain.impl;

import com.company.domain.ItemType;

public class PotionImpl extends ItemImpl {

    private int hpAdd;

    public PotionImpl(String name, ItemType type, int hpAdd) {
        super(name, ItemType.POTION);
        this.hpAdd = hpAdd;
    }

    public int getHealingVal() {
        return hpAdd;
    }
}
