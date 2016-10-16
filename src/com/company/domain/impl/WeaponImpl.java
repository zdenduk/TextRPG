package com.company.domain.impl;

import com.company.domain.Item;
import com.company.domain.ItemType;

public class WeaponImpl extends ItemImpl {

    public WeaponImpl(String name, ItemType type, int attackDamage) {
        super(name, type);
        this.attackDamage = attackDamage;
    }

    private int attackDamage;

    public int getAttackDamage() {
        return attackDamage;
    }

}
