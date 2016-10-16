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
        Option selectedOption = DoMove(location, player);
        play(selectedOption.getLocation(), player);
    }

    private void presentLocation(Location location, Player player) {
        System.out.println(location.getText());
        int index = 1;
        for (Option option : location.getOptions()) {
            System.out.println(index + ") " + option.getText());
            index++;
        }
    }

    private Option DoMove(Location location, Player player) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt() - 1;

        if (location.getOptions().get(num).getLocation()==null) {
            pickItem(location, player, num);
            return location.getOptions().get(num - 1);
        } else {
            return location.getOptions().get(num);
        }
    }

    private void pickItem(Location location, Player player, int a) {
        player.addItem(location.getOptions().get(a).getItem());
        location.removeOption(location.getOptions().get(2));
    }

}

/*
typy itemu
*/
