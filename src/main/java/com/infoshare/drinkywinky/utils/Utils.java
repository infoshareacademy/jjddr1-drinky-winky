package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.properties.ConfigLoader;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Utils {

    public Utils() {
    }

    /**
     * @param drinkList List<Drink>
     * @return only names of all drink
     */
    public static List<String> getNamesOfAllDrink(DrinkList drinkList) {
        return drinkList.getAllDrink()
                .stream()
                .map(Drink::getName)
                .collect(Collectors.toList());
    }

    /**
     * @param drinkList List<Drink>
     * @return only category of each drink
     */
    public static Set<String> getCategoryOfAllDrink(DrinkList drinkList) {
        return drinkList.getAllDrink()
                .stream().
                        map(Drink::getCategory)
                .collect(Collectors.toSet());
    }

    /**
     * @param drinkList List<Drink>
     * @return only unique names included in each drink
     */
    public static Set<String> getNamesOfAllIngredients(DrinkList drinkList) {
        Set<String> ingredients = new HashSet<>();
        List<Drink> allDrink = drinkList.getAllDrink();
        for (Drink drink : allDrink) {
            drink.getIngredients().forEach(e -> ingredients.add(e.toLowerCase()));
        }
        return ingredients;
    }

    /**
     * @param length takes number from 0 to 40
     * @return a random number of the given length
     */
    public static String getRandomId(int length) {
        String randomId = String
                .format("%040d", new BigInteger(UUID.randomUUID()
                        .toString()
                        .replace("-", ""), 16));
        return randomId.substring(randomId.length() - length);
    }

    /**
     * @param ingredients List<String>, measures List<String>
     * @return list of ingredients with it's measurements
     */
    public static List<String> getIngredientsWithMeasures(List<String> ingredients, List<String> measures) {
        List<String> listOfIngredientsWithMeasures = new ArrayList<>();
        if (ingredients.size() == measures.size()) {
            for (int i = 0; i < ingredients.size(); i++) {
                String ingredientToConcat = ingredients.get(i);
                String measureToConcat = measures.get(i);
                String concat = measureToConcat.concat(" " + ingredientToConcat);
                listOfIngredientsWithMeasures.add(concat);
            }
        } else {
                String ingredientWithoutMeasure = ingredients.get(0);
                listOfIngredientsWithMeasures.add(ingredientWithoutMeasure);
            for (int i = 0; i < measures.size(); i++) {
                String ingredientToConcat = ingredients.get(i + 1);
                String measureToConcat = measures.get(i);
                String concat = measureToConcat.concat(" " + ingredientToConcat);
                listOfIngredientsWithMeasures.add(concat);
            }
        }
        return listOfIngredientsWithMeasures;
    }
}
