package com.infoshare.drinkywinky;

import com.infoshare.drinkywinky.menu.ChoiceMenu;
import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Repository repository = new Repository();
//        ChoiceMenu.choiceMenu();
            Menu.mainMenu();


        /**
         * Method must run only when application is opened for the first time or on user demand
         * User must have an option in menu to use it
         */
//        Repository.saveToNewFile();

        /**
         * Displays main menu
         */
//        Menu.mainMenu();

        //getDrinkList() should use inside class
//        final List<Drink> allDrink = Repository.getInstance().getDrinkList().getAllDrink();
//        System.out.println(allDrink);

        /**
         * Method to add a new drink into the list of drinks
         */
//        List<String> ingredients = new ArrayList<>();
//        ingredients.add("Salt");
//        ingredients.add("Alcohol");
//        Drink annaDrink = new Drink("02", "Anna", "Ordinary drink", ingredients);
//        System.out.println(annaDrink);

        /*
         way to display drink by enter name
         */
//        String name = "Blue Margarita";




        /*
          SINGLETON to use for Repository getters

          Repository.getInstance().getSOMETHING
         */
//        List<Drink> salt = Repository.getInstance().getListOfDrinkByIngredient("Salt");


        /**
         * Method to display drink's name by it's ingredient ("Salt") entered by user
         */
//        for (Drink drink : salt) {
//            System.out.println(drink.getName());
//        }

    }
}
