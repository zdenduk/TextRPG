package com.company.domain;

import java.util.List;

public interface Location {
    List<Option> getOptions();
    String getText();
    void addOption(String text, Location targetLocation);
    void addOption(String text, Item item);
    void addOption(String text, Arena arena);

    List<Item> getItems();
    void addItem(Item item);
    void addItem(String name, ItemType type);
    void removeItem(Item item);
    void removeOption(Option option);
}
