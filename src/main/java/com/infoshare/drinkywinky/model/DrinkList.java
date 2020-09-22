package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DrinkList {

    private final List<Drink> allDrink;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public DrinkList(@JsonProperty("drinks") List<Drink> allDrink) {
        this.allDrink = allDrink;
    }

    public List<Drink> getAllDrink() {
        return allDrink;
    }

    public Drink getDrinkById(String id) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getId().equals(id)) {
                return drink;
            }
        }
        return null;
    }

    public Drink getDrinkByName(String name) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getName().equalsIgnoreCase(name)) {
                return drink;
            }
        }
        return null;
    }

    public Drink getDrinkByCategory(String category) {

   //     allDrink.stream().filter(e -> e.getCategory().contains(category)).map(e->e.getCategory());

        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getCategory().contains(category)) {
                return drink;
            }
        }
        return null;
    }

    public List<Drink> getDrinkByIngredients(String ingredient) {
        List<Drink> drinkList = getAllDrink();
        List<Drink> result = new ArrayList<>();
        for (Drink drink : drinkList) {
            if (drink.getIngredients().contains(ingredient)) {
                result.add(drink);
            }
        }
        return result;
    }

    // maybe it should be in utils
//    public Drink getCategoryByName(String name) {
//        List<Drink> drinkList = getAllDrink();
//        for (Drink drink : drinkList) {
//            if (drink.getCategory().equals(name)) {
//                return drink;
//            }
//        }
//        return null;
//    }

    @Override
    public String toString() {
        return "Drinks list:\n\n\n" + allDrink + "\n";
    }

}
