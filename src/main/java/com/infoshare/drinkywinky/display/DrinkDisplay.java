package com.infoshare.drinkywinky.display;


import java.util.List;

public class DrinkDisplay {
    private int menuPosition;
    private String menuDrink;

    public DrinkDisplay(int menuPosition, String menuDrink) {
        this.menuPosition = menuPosition;
        this.menuDrink = menuDrink;
    }

    public DrinkDisplay() {

    }

    public int getMenuPosition() {
        return menuPosition;
    }

    public String getMenuDrink() {
        return menuDrink;
    }

    public void setMenuPosition(int menuPosition) {
        this.menuPosition = menuPosition;
    }

    public void setMenuDrink(String menuDrink) {
        this.menuDrink = menuDrink;
    }

    @Override
    public String toString() {
        return menuPosition+"."+" "+ menuDrink;
    }
}

