package com.company.ui;

import com.company.domain.*;
import com.company.domain.impl.ArmorImpl;
import com.company.domain.impl.PotionImpl;
import com.company.domain.impl.WeaponImpl;

import java.util.Scanner;

public class GameUI {

    public void play(Location location, Player player) {
        if (location == null) {
            throw new IllegalArgumentException("starting location is null");
        }
        if (!location.getItems().isEmpty()) {
            location.getItems().forEach((item) -> System.out.println("There is " + item.getName()));
        }
        if (escaped(location)) {
            System.out.println("I escaped.");
        }
        if (died(player)) {
            System.out.println("Rest in peace");
        } else if (!escaped(location)) {
            presentLocation(location);
            Location newLocation = doMove(location, player);
            play(newLocation, player);
        }
    }

    private void presentLocation(Location location) {
        System.out.println(location.getText());
        int index = 1;
        System.out.println("0) Inventory");
        for (Option option : location.getOptions()) {
            System.out.println(index + ") " + option.getText());
            index++;
        }
    }

    private Location doMove(Location location, Player player) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        int input = sc.nextInt() - 1;
        /* check if arena or item or location or inventory */
        if (input == -1) {
            System.out.println("I have these following items:");
            for (Item item : player.getItems()) {
                System.out.println(counter + ") " + item.getName());
                counter++;
            }
            useItem(player);

            return location;
        } else if (location.getOptions().get(input).getLocation() == null && location.getOptions().get(input).getArena() == null) {
            pickItem(location, player, input);
            return location;
        } else if (location.getOptions().get(input).getItem() == null && location.getOptions().get(input).getLocation() == null) {
            location.getOptions().get(input).getArena().turn(player, location.getOptions().get(input).getArena().getEnemies().get(0));
            return location;
        } else {
            return location.getOptions().get(input).getLocation();
        }
    }

    private void pickItem(Location location, Player player, int a) {
        player.addItem(location.getOptions().get(a).getItem());
        location.removeOption(location.getOptions().get(a));
    }

    private boolean escaped(Location location) {
        if (location.getOptions().isEmpty())
            return true;
        else
            return false;

    }

    private boolean died(Player player) {
        if (player.getHp() <= 0)
            return true;
        else
            return false;
    }

    private void useItem(Player player) {
        System.out.println("Which item do I use?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        input--;
        if (player.getItems().get(input).getItemType().getCaption().equals("potion")) {
            PotionImpl potion = (PotionImpl) player.getItems().get(input);
            player.setHp(player.getHp() + potion.getHealingVal());
            System.out.println("My current HP is " + player.getHp());
            player.removeItem(player.getItems().get(input));
        }
        else if (player.getItems().get(input).getItemType().getCaption().equals("weapon")) {
            WeaponImpl weapon = (WeaponImpl) player.getItems().get(input);
            player.setWeapon(weapon);
            System.out.println("My "+ weapon.getName() + " is ready.");
        }
        else if (player.getItems().get(input).getItemType().getCaption().equals("armor")) {
            ArmorImpl armor = (ArmorImpl) player.getItems().get(input);
            player.setArmor(armor);
            System.out.println("I have " + armor.getName() + " put on.");
        }
    }
}

