package com.company.tests;

import com.company.domain.Location;
import com.company.domain.Player;
import com.company.domain.impl.LocationImpl;
import com.company.domain.impl.PlayerImpl;

import static org.junit.Assert.*;

public class PlayerImplTest {
    @org.junit.Test
    public void getHp() throws Exception {
        Location location = new LocationImpl("kok");
        Player player = new PlayerImpl("kok", 100, location);
        assertEquals(100 ,player.getHp());
    }

}