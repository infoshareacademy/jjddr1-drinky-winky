package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DataDownloadMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner SCANNER = new Scanner(System.in);




    public static String getRandomId () {
        String randomId = String
                .format("%040d", new BigInteger(UUID.randomUUID()
                        .toString()
                        .replace("-", ""),16));
        return randomId.substring(randomId.length() - 7);
    }

    public static void main(String[] args) {


//        String randomId = UUID.randomUUID().toString();
//        String uuid1 = UUID.randomUUID().toString();
//        String uuid2 = UUID.randomUUID().toString();
//        System.out.println(randomId);
//        System.out.println(uuid1);
//        System.out.println(uuid2);


        System.out.println(getRandomId());


        List<String> ingredientsList = new ArrayList<>();

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

        STDOUT.info("Fill INGREDIENT: \n");
        String ingredient = SCANNER.nextLine();
        ingredientsList.add(ingredient);

        Drink drink = new Drink(id, name, category, recipe, alcoholic, glass, ingredientsList);

        System.out.println(drink);
    }
}
