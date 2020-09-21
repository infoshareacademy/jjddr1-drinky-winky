package com.infoshare.drinkywinky;

import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

     //   Menu.mainMenu();

     //   System.out.println(Repository.getInstance().getDrinkList());


        /**
         * way to add new drink
         */
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Salt");
        ingredients.add("Alcohol");


        Drink annaDrink = new Drink("02", "Anna", "Ordinary drink", ingredients);

        System.out.println(annaDrink);


    }
 }
