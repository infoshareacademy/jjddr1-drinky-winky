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
    private static String id = Utils.getRandomId(7); //number of id char length
    private static String dateModified = "2020.04.05"; //please fix this field
    private static List<String> ingredientsList;
    private static List<String> measuresList;
    private static String name;
    private static String category;
    private static String alcoholic;
    private static String recipe;
    private static String glass;


    public static void scannerInputFromUser() {
        STDOUT.info("Enter drink NAME: \n");
        name = SCANNER.nextLine();
        STDOUT.info("Enter CATEGORIES of a drink: \n");
        category = SCANNER.nextLine();
        STDOUT.info("Give the RECIPE: \n");
        recipe = SCANNER.nextLine();
        isAlcoholic();
        STDOUT.info("Write the kind of GLASS: \n");
        glass = SCANNER.nextLine();
        STDOUT.info("Enter ingredients each separated with a coma: \n");
        ingredientsList = addIngredients(SCANNER.nextLine());
        STDOUT.info("Enter measures each separated with a com: \n");
        measuresList = addMeasures(SCANNER.nextLine());
        addNewDrink();
    }

    /**
     * @param userIngredients names of ingredients separate with coma
     * @return list containing the names of the ingredients
     */
    private static List<String> addIngredients(String userIngredients) {
        return Arrays.asList(userIngredients.split(",").clone());
    }

    /**
     * @param userMeasures names of measures separate with coma
     * @return list containing the value of measures
     */
    private static List<String> addMeasures(String userMeasures) {
        return Arrays.asList(userMeasures.split(",").clone());

    }

    // WHAT IF USER INPUT DIFFERENT LETTER THAN Y/N?
    //    STDOUT.info("You've inserted wrong letter!\nPlease insert 'y' or 'n': ");
    private static void isAlcoholic() {
        STDOUT.info("Is it ALCOHOLIC drink? Y/Yes or N/No \n");
        if (SCANNER.nextLine().equalsIgnoreCase("y"))
            alcoholic = "Alcoholic";
        else
            alcoholic = "No-Alcoholic";
    }

    private static void addNewDrink() {
        Repository.getInstance()
                .add(new Drink(
                        id,
                        name,
                        category,
                        recipe,
                        alcoholic,
                        dateModified,
                        glass,
                        ingredientsList,
                        measuresList));
    }
}