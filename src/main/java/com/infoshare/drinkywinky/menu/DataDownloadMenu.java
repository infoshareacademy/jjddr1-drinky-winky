package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.model.Drink;

import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.DateFormatter;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataDownloadMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * @param userIngredients names of ingredients separate with coma
     * @return list containing the names of the ingredients
     */
    public static List<String> addIngredients(String userIngredients) {
        return Arrays.asList(userIngredients.split(",").clone());
    }

    //test class only!!!
    public static void main(String[] args) {
        //fields should be private after test in MAIN CLASS
        String id = Utils.getRandomId(7); //number of id char length;
        String dateModified = String.valueOf(DateFormatter.formatter);
        List<String> ingredientsList;
        List<String> measuresList;
        String name;
        String category;
        String alcoholic;
        String recipe;
        String glass;

        STDOUT.info("Enter drink NAME: \n");
        name = SCANNER.nextLine();

        STDOUT.info("Enter CATEGORIES of drink: \n");
        category = SCANNER.nextLine();

        STDOUT.info("Give the RECIPE: \n");
        recipe = SCANNER.nextLine();

        STDOUT.info("Is it ALCOHOLIC drink? Y/Yes or N/No \n");
        if (SCANNER.nextLine().equalsIgnoreCase("y")) {
            alcoholic = "Alcoholic";
        } else {
            alcoholic = "No-Alcoholic";
        }

        STDOUT.info("Pass the GLASS: \n");
        glass = SCANNER.nextLine();

        STDOUT.info("Enter ingredients and separate with a coma: \n");
        ingredientsList = addIngredients(SCANNER.nextLine());

        STDOUT.info("Enter measures and separate with a coma: \n");
        measuresList = addIngredients(SCANNER.nextLine());

        //created new Drink object for test
        Drink drink = new Drink(
                id,
                name,
                category,
                recipe,
                alcoholic,
                dateModified,
                glass,
                ingredientsList,
                measuresList
        );

        Repository.getInstance().add(drink);
        //check new Drink object
        System.out.println(drink);
    }
}
