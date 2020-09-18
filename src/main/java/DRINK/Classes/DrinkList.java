package DRINK.Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class DrinkList {

    private final List<Drink> allDrink;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public DrinkList(@JsonProperty("alldrinks") List<Drink> allDrink) {
        this.allDrink = allDrink;

    }


    public List<Drink> getAllDrink() {
        return allDrink;
    }

    public Drink getDrinkById(String id) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getIdDrink().equals(id)) {
                return drink;
            }
        }
        return null;
    }

    public Drink getDrinkByName(String name) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getStrDrink().equals(name)) {
                return drink;
            }
        }
        return null;
    }

    public Drink getCategoryByName(String name) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getStrCategory().equals(name)) {
                return drink;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Drinks list:\n\n\n" + allDrink+"\n";
    }
}
