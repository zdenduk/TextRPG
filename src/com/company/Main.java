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
        Location startingLocation = new LocationImpl("Starting location");
        Location leftLocation = new LocationImpl("You are in the left room");
        Location rightLocation = new LocationImpl("You are in the right room");
        Item bfsword = new WeaponImpl("B.F. Sword", WEAPON, 50);
        Item pickaxe = new WeaponImpl("Pickaxe", WEAPON, 25);
        Item healingPotion = new PotionImpl("Healing Potion", POTION, 150);
        Item warmogsArmor = new ArmorImpl("Thornmail", ARMOR, 100);
        startingLocation.addOption("Turn left", leftLocation);
        startingLocation.addOption("Turn right", rightLocation);
        rightLocation.addOption("Left way", leftLocation);
        rightLocation.addOption("Back to start", startingLocation);
        leftLocation.addOption("Right way", rightLocation);
        leftLocation.addOption("Back to start", startingLocation);
        leftLocation.addOption("Pick up B.F. Sword", bfsword);
        rightLocation.addOption("Pick up pickaxe", pickaxe);

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
