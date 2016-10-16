package com.company.ui;

import com.company.domain.Location;
import com.company.domain.Option;
import com.company.domain.Player;

import java.util.Scanner;

public class GameUI {

    public void play(Location location, Player player) {
        if (location == null) {
            throw new IllegalArgumentException("starting location is null");
        }
        if (!location.getItems().isEmpty()) {
            location.getItems().forEach((item) -> System.out.println("There is " + item.getName()));
        }
        presentLocation(location, player);
        Location newLocation = DoMove(location, player);
        play(newLocation, player);
        /*Option selectedOption = DoMove(location, player);
        play(selectedOption.getLocation(), player);*/
    }

    private void presentLocation(Location location, Player player) {
        System.out.println(location.getText());
        int index = 1;
        for (Option option : location.getOptions()) {
            System.out.println(index + ") " + option.getText());
            index++;
        }
    }

    private Location DoMove(Location location, Player player) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt() - 1;
        System.out.println(input);
        if (location.getOptions().get(input).getLocation() == null) {
            pickItem(location, player, input);
            return location; /* nějak kurva zůstat v stejný lokaci */
        } else {
            return location.getOptions().get(input).getLocation();
        }
    }

    private void pickItem(Location location, Player player, int a) {
        player.addItem(location.getOptions().get(a).getItem());
        location.removeOption(location.getOptions().get(a));
    }

}

/*
typy itemu
*/
