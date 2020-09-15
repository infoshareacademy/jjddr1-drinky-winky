package RozwalkaWojciech;

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

    @Override
    public String toString() {
        return "DrinkList{" +
                "allDrink=" + allDrink +
                '}';
    }
}
