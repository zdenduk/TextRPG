package com.company.domain;

import java.util.List;

public interface Location {
    List<Option> getOptions();
    String getText();
    void addOption(String text, Location targetLocation);
    void addOption(String text, Item item);


    List<Item> getItems();
    void addItem(Item item);
    void addItem(int durability,int ad,String name);
    void removeItem(Item item);
    void removeOption(Option option);
}
