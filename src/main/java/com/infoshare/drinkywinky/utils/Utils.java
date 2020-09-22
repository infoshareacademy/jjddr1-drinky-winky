package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.repositories.Repository;

public class Utils {

    public Utils() {
    }

    public static void displayDrinkNames() {
        System.out.println(Repository.getInstance().getDrinkList().getAllDrink());
    }

    public static void displayDrinkByName(String name) {
        System.out.println(Repository.getInstance().getDrinkByName(name));
    }

}
