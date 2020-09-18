package drink.classes;

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
            if (drink.getId().equals(id)) {
                return drink;
            }
        }
        return null;
    }

    public Drink getDrinkByName(String name) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getName().equals(name)) {
                return drink;
            }
        }
        return null;
    }

    public Drink getCategoryByName(String name) {
        List<Drink> drinkList = getAllDrink();
        for (Drink drink : drinkList) {
            if (drink.getCategory().equals(name)) {
                return drink;
            }
        }
        return null;
    }

    public List<Drink> getDrinksByIngredients(String ingredient) {
        List<Drink> drinkList = getAllDrink();
        List<Drink> result = new ArrayList<>();
        for (Drink drink : drinkList) {
            if (drink.getIngredients().contains(ingredient)) {
                result.add(drink);
            }
        }
        return result;
    }

    public List<Drink> getDrinksByCategory(String category) {
        List<Drink> drinkList = getAllDrink();
        List<Drink> result = new ArrayList<>();
        for (Drink drink : drinkList) {
            if (drink.getCategory().contains(category)) {
                result.add(drink);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Drinks list:\n\n\n" + allDrink+"\n";
    }

}
