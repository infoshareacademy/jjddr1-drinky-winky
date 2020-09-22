package com.infoshare.drinkywinky;

import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
          METHOD MUST RUN ONLY ONCE!
          WHEN USER OPEN APP FIRST TIME, OR FOR HIS REQUEST!
          Option should be selected from the MENU!
         */
        Repository.saveToNewFile();

        /*
         display main menu
        */
        Menu.mainMenu();

        //getDrinkList() should use inside class
//        final List<Drink> allDrink = Repository.getInstance().getDrinkList().getAllDrink();
//        System.out.println(allDrink);

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
         way to display drink by enter name
         */
        String name = "Blue Margarita";




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
