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

<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/InputDataUser.java
    /**
     * User input from scanner all data needed to add a new drink to list.
     */
    public static void scannerInputFromUser() {
=======
=======
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
    InputDataUser() {
    }

    public static void scannerInput() {
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
>>>>>>> dde148f55ee45f71fe5c3e21a924e3b8866f135b:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
=======
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
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
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/InputDataUser.java
     * @param userIngredients names of ingredients
     * @return list containing the names of the ingredients
=======
     * @param userIngredients names of ingredients separate with coma
>>>>>>> dde148f55ee45f71fe5c3e21a924e3b8866f135b:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
=======
     * @param userIngredients names of ingredients separate with coma
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
     */
    private static void addIngredients(String userIngredients) {
        INGREDIENTS.add(userIngredients);
    }

    /**
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/InputDataUser.java
     * @param userMeasures names of measures
     * @return list containing the value of measures
=======
     * @param userMeasures names of measures separate with coma
>>>>>>> dde148f55ee45f71fe5c3e21a924e3b8866f135b:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
=======
     * @param userMeasures names of measures separate with coma
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
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

<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/InputDataUser.java
    /**
     * Method which allows user to input ingredients from scanner
     * and concat it with measure from measureInputFromUser().
     * Method exits with isAlcoholic()
     */
    private static void ingredientInputFromUser() {
        STDOUT.info("Enter an ingredient and press Enter." +
                    "\nIf you're finished press Enter to quit.\n");
        userInput = SCANNER.nextLine();
=======
=======
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
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
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
>>>>>>> dde148f55ee45f71fe5c3e21a924e3b8866f135b:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
=======
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
        if (userInput.equalsIgnoreCase("")) {
            isAlcoholic();
        } else {
            addIngredients(userInput);
            measureInput();
        }
    }

<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
<<<<<<< HEAD:src/main/java/com/infoshare/drinkywinky/menu/InputDataUser.java
    /**
     * Method which allows user to input measure from scanner
     * and concat it with ingredient from ingredientInputFromUser().
     */
    private static void measureInputFromUser() {
        STDOUT.info("Enter a measurement. " +
                    "If you're finished press Enter to input next ingredient.\n");
=======
    private static void measureInput() {
        STDOUT.info("Enter a measurement and press Enter." +
                "\n -->  If you're finished press Enter to quit  <-- \n");
>>>>>>> dde148f55ee45f71fe5c3e21a924e3b8866f135b:src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
=======
    private static void measureInput() {
        STDOUT.info("Enter a measurement and press Enter." +
                "\n -->  If you're finished press Enter to quit  <-- \n");
>>>>>>> 87c6f0d8d4025ef20557e4df0b9fb3d20acb5275:console Drinky-Winky/src/main/java/com/infoshare/drinkywinky/menu/managment/InputDataUser.java
        if (SCANNER.hasNextLine()) {
            addMeasures(SCANNER.nextLine());
        }
        ingredientInput();
    }
}
