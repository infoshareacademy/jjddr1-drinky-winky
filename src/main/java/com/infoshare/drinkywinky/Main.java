package com.infoshare.drinkywinky;

import com.infoshare.drinkywinky.menu.Menu;

import com.infoshare.drinkywinky.properties.ConfigLoader;
import com.infoshare.drinkywinky.repositories.Repository;

public class Main {

    public static void main(String[] args) {

        /*
         display main menu
        */
        new ConfigLoader().loadAppConfig();
        Menu.intro();
        Menu.mainMenu();
        /*
          way to add new drink
         */
//        List<String> ingredients = new ArrayList<>();
//        ingredients.add("Salt");
//        ingredients.add("Alcohol");
//
//        Drink annaDrink = new Drink("02", "Anna", "Ordinary drink", ingredients);
//
//        System.out.println(annaDrink);

        /*
          SINGLETON to use for Repository getters

          Repository.getInstance().getSOMETHING
         */
//        List<Drink> salt = Repository.getInstance().getListOfDrinkByIngredient("Salt");

        /*
          Way to print drink names after the ingredient ("Salt") searched
         */
//        for (Drink drink : salt) {
//            System.out.println(drink.getName());
//        }

    }
}
