package com.company.domain.impl;
import com.company.domain.ItemType;

public class PotionImpl extends ItemImpl {

    public PotionImpl(String name, ItemType type, int hpAdd) {
        super(name, type);
        this.hpAdd = hpAdd;
    }

    private int hpAdd;

    public int getAttackDamage() {
        return hpAdd;
    }

}
