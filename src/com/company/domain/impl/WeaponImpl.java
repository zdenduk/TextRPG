package com.company.domain.impl;

import com.company.domain.ItemType;

public class WeaponImpl extends ItemImpl{

    public WeaponImpl(String name, ItemType type, int attackDamage) {
        super(name, ItemType.WEAPON);
        this.attackDamage = attackDamage;
    }

    private int attackDamage;

    public int getAttackVal() {
        return attackDamage;
    }

}
