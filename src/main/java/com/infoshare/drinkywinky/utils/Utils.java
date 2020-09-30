package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.repositories.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    public Utils() {
    }

    /**
     * @return only names of all drink
     */
    public static List<String> getNamesOfAllDrink() {
        return Repository.getInstance().getDrinkList().getAllDrink()
                .stream()
                .map(Drink::getName)
                .collect(Collectors.toList());
    }

    /**
     * @return only Cathegory of each drink.
     */
    public static Set<String> getCategoryOfAllDrink() {
        return Repository.getInstance().getDrinkList().getAllDrink()
                .stream().
                        map(Drink::getCategory)
                .collect(Collectors.toSet());
    }

    /**
     * @return only unique names included in each drink
     */
    public static Set<String> getNamesOfAllIngredients() {
        Set<String> ing = new HashSet<>();
        List<Drink> allDrink = Repository.getInstance().getDrinkList().getAllDrink();
        for (Drink drink : allDrink) {
            List<String> ingredients = drink.getIngredients();
            ing.addAll(ingredients);
        }

        return ing;
    }
}
