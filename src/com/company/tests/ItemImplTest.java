package com.company.tests;

import com.company.domain.Item;
import com.company.domain.Location;
import com.company.domain.Player;
import com.company.domain.impl.WeaponImpl;

import static com.company.domain.impl.ItemTypeImpl.WEAPON;
import static org.junit.Assert.*;

public class ItemImplTest {
    @org.junit.Test
    public void getHp() throws Exception {
        Item item = new WeaponImpl("name", WEAPON, 100);
        assertEquals("name", item.getName());
    }

}