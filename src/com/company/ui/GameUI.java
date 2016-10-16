package com.company.ui;

import com.company.domain.Item;
import com.company.domain.Location;
import com.company.domain.Option;
import com.company.domain.Player;
import com.company.domain.impl.PotionImpl;

import java.util.Scanner;

public class GameUI {

    public void play(Location location, Player player) {
        if (location == null) {
            throw new IllegalArgumentException("starting location is null");
        }
        if (!location.getItems().isEmpty()) {
            location.getItems().forEach((item) -> System.out.println("There is " + item.getName()));
        }
        if (endGame(location)) {
            System.out.println("I escaped.");
        }
        presentLocation(location, player);
        Location newLocation = DoMove(location, player);
        play(newLocation, player);
    }

    private void presentLocation(Location location, Player player) {
        System.out.println(location.getText());
        int index = 1;
        System.out.println("0) Inventory");
        for (Option option : location.getOptions()) {
            System.out.println(index + ") " + option.getText());
            index++;
        }
    }

    private Location DoMove(Location location, Player player) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        int input = sc.nextInt() - 1;
        if (input == -1) {
            System.out.println("I have these following items:");
            for (Item item : player.getItems()) {
                System.out.println(counter + ") " + item.getName());
                counter++;
            }
            useItem(player);

            return location;
        } else if (location.getOptions().get(input).getLocation() == null) {
            pickItem(location, player, input);
            return location;
        } else {
            return location.getOptions().get(input).getLocation();
        }
    }

    private void pickItem(Location location, Player player, int a) {
        player.addItem(location.getOptions().get(a).getItem());
        location.removeOption(location.getOptions().get(a));
    }

    private boolean endGame(Location location) {
        if (location.getOptions().isEmpty())
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
            player.removeItem(player.getItems().get(input));

            PotionImpl potion = (PotionImpl) player.getItems().get(0);
            player.setHp(potion.getHealingVal());/* TODO somehow explain this */
        }
    }
}

