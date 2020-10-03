package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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

    public static void main(String[] args) {

        String id = Utils.getRandomId(7);
        String dateModified = "2020.04.05";
        List<String> ingredientsList = new ArrayList<>();
        List<String> measuresList = new ArrayList<>();

        STDOUT.info("Fill ID: \n");
        String id = SCANNER.nextLine();

        STDOUT.info("Fill NAME: \n");
        String name = SCANNER.nextLine();

        STDOUT.info("Fill CATEGORY: \n");
        String category = SCANNER.nextLine();

        STDOUT.info("Fill RECIPE: \n");
        String recipe = SCANNER.nextLine();

        STDOUT.info("Fill ALCOHOLIC: \n");
        String alcoholic = SCANNER.nextLine();

        STDOUT.info("Fill GLASS: \n");
        String glass = SCANNER.nextLine();

        STDOUT.info("Enter ingredient and separate with a coma: \n");
        ingredientsList = addIngredients(SCANNER.nextLine());

        STDOUT.info("Fill MEASURES: \n");
        String measures = SCANNER.nextLine();
        measuresList.add(measures);


        //created new Drink object
        Drink drink = new Drink(id, name, category, recipe, alcoholic, dateModified, glass, ingredientsList);

        //check new Drink object
        System.out.println(drink);
    }
}
