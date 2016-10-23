package com.company.domain;

public enum ItemType {
    POTION("potion"),
    WEAPON("weapon"),
    ARMOR("armor");

    private String caption;

    private ItemType(String a) {
        this.caption = a;
    }

    public String getCaption() {
        return caption;
    }
}
