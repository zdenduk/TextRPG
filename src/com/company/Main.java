package com.company;

import com.company.domain.Item;
import com.company.domain.ItemType;
import com.company.domain.Location;
import com.company.domain.Player;
import com.company.domain.impl.*;
import com.company.ui.GameUI;
import com.sun.org.glassfish.external.probe.provider.PluginPoint;

import java.util.Scanner;

import static com.company.domain.impl.ItemTypeImpl.ARMOR;
import static com.company.domain.impl.ItemTypeImpl.POTION;
import static com.company.domain.impl.ItemTypeImpl.WEAPON;

public class Main {

    public static void main(String[] args) {
        Location startingLocation = createGame();
        Player newPlayer = createPlayer(startingLocation);
        GameUI gameUI = new GameUI();
        gameUI.play(startingLocation, newPlayer);
    }

    private static Location createGame() {

        Location startingLocation = new LocationImpl("Where am I,");
        Location forest = new LocationImpl("That's a really deep forest...");
        Location tower = new LocationImpl("I almost thought these stairs would never end.");
        Location castle = new LocationImpl("Whoa... This castle is huge.");
        Location burrow = new LocationImpl("Hopefully there won't be any animals.");

        Item bfsword = new WeaponImpl("B.F. Sword", WEAPON, 50);
        Item pickaxe = new WeaponImpl("Pickaxe", WEAPON, 25);
        Item healingPotion = new PotionImpl("Healing Potion", POTION, 150);
        Item thornmail = new ArmorImpl("Thornmail", ARMOR, 100);

        startingLocation.addOption("This forest seems definitely dangerous.", forest);
        startingLocation.addOption("There is a castle nearby. Maybe I could sneak in?", castle);

        castle.addOption("Go into tower.", tower);
        castle.addOption("This is definitely not the right way.", startingLocation);
        castle.addOption("Pick up healing potion.", healingPotion);

        tower.addOption("Back to castle.", castle);
        tower.addOption("Pick up pickaxe.", pickaxe);

        forest.addOption("Maybe this is not the right way. I should go back to that castle I saw earlier.", castle);
        forest.addOption("Get back!", startingLocation);
        forest.addOption("A burrow! I wonder what's inside...", burrow);
        forest.addOption("Pick up B.F. Sword.", bfsword);

        burrow.addOption("What a beautiful armor.", thornmail);

        return startingLocation;
    }

    private static Player createPlayer(Location location) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell me your name");
        String name = sc.nextLine();
        Player player = new PlayerImpl(name, 100, location);
        return player;
    }
}
