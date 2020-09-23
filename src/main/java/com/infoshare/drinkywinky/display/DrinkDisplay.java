package com.infoshare.drinkywinky.display;


import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;

import java.security.Key;
import java.util.List;

import java.util.Scanner;
import java.util.TreeMap;

public class DrinkDisplay {

    private static Integer menuNumber;
    private static String menuDrink;
    private static TreeMap<Integer, String> menuMap;

    public DrinkDisplay() {
    }

    public static TreeMap<Integer, String> getMenuMap() {
        return menuMap;
    }



    public static TreeMap preparingMenu() {
        List<String> drinkList = Utils.getNamesOfAllDrink();
        menuMap = new TreeMap<>();
        for (menuNumber = 1; menuNumber < drinkList.size(); menuNumber++) {
            menuMap.put(menuNumber,menuDrink = drinkList.get(menuNumber));
        }

        return menuMap;
    }
    public static void  menuService () {
        System.out.println("\n"+preparingMenu());
        System.out.println("\n Please enter the number of the menu item you are interested in.\n");
        Scanner scanner = new Scanner(System.in);
        Integer choice = scanner.nextInt();
        if (preparingMenu().containsKey(choice)){
            String selectedDrink = (String) preparingMenu().get(choice);
            System.out.println("Your choice is: "+selectedDrink+
                    "\n Recipe for your "+ selectedDrink+" is: \n"+ Repository.getInstance().getDrinkByName(selectedDrink));
        }else System.out.println("Wrong choice.");

    }

}


