package com.infoshare.drinkywinky.menu.managment;

import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputDataUser {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DATE_MODIFIED = String.valueOf(LocalDateTime.now());
    private static final List<String> INGREDIENTS = new ArrayList<>();
    private static final List<String> MEASURES = new ArrayList<>();
    private static String id = Utils.getRandomId(7);
    private static String name;
    private static String category;
    private static String alcoholic;
    private static String recipe;
    private static String glass;

    InputDataUser() {
    }

    public static void scannerInput() {
        STDOUT.info("Enter drink NAME: \n");
        name = SCANNER.nextLine();
        STDOUT.info("Enter CATEGORIES of a drink: \n");
        category = SCANNER.nextLine();
        STDOUT.info("Give the RECIPE: \n");
        recipe = SCANNER.nextLine();
        STDOUT.info("Write the kind of GLASS: \n");
        glass = SCANNER.nextLine();
        ingredientInput();
        addDrink();
        id = Utils.getRandomId(7);
    }

    /**
     * @param userIngredients names of ingredients separate with coma
     */
    private static void addIngredients(String userIngredients) {
        INGREDIENTS.add(userIngredients);
    }

    /**
     * @param userMeasures names of measures separate with coma
     */
    private static void addMeasures(String userMeasures) {
        MEASURES.add(userMeasures);
    }

    private static void isAlcoholic() {
        STDOUT.info("Is it ALCOHOLIC drink? Y/Yes or N/No \n");
        if (SCANNER.nextLine().equalsIgnoreCase("y"))
            alcoholic = "Alcoholic";
        else
            alcoholic = "No-Alcoholic";
    }

    private static void addDrink() {
        Repository.getInstance()
                .add(new Drink(
                        id,
                        name,
                        category,
                        recipe,
                        alcoholic,
                        DATE_MODIFIED,
                        glass,
                        INGREDIENTS,
                        MEASURES));
    }

    private static void ingredientInput() {
        STDOUT.info("Enter an ingredient and press Enter." +
                "\n --> If you're finished press Enter to quit  <-- \n");
        String userInput = SCANNER.nextLine();
        if (userInput.equalsIgnoreCase("")) {
            isAlcoholic();
        } else {
            addIngredients(userInput);
            measureInput();
        }
    }

    private static void measureInput() {
        STDOUT.info("Enter a measurement and press Enter." +
                "\n -->  If you're finished press Enter to quit  <-- \n");
        if (SCANNER.hasNextLine()) {
            addMeasures(SCANNER.nextLine());
        }
        ingredientInput();
    }
}