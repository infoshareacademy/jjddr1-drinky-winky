package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DrinkList {

    private final List<Drink> allDrink;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public DrinkList(@JsonProperty("drinks") List<Drink> allDrink) {
        this.allDrink = allDrink;
    }

    public List<Drink> getAllDrink() {
        return allDrink;
    }

    public void addDrink(Drink drink) {
        allDrink.add(drink);
    }

    public void removeDrink(Drink drink) {
        allDrink.remove(drink);
    }

    public Drink getDrinkById(String id) {
        for (Drink drink : allDrink)
            if (drink.getId().equals(id)) {
                return drink;
            }
        return null;
    }

    public List<Drink> getDrinkListByName(String name) {
        return allDrink
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public Drink getDrinkByName(String name) {
        for (Drink drink : allDrink) {
            if (drink.getName().equals(name)) {
                return drink;
            }
        }
        return null;
    }

    public Set<Drink> getDrinkByCategory(String category) {
        return allDrink
                .stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toSet());
    }

    public List<Drink> getDrinkByIngredients(String ingredient) {
        return allDrink
                .stream()
                .filter(e ->
                        e.getIngredients().stream().anyMatch(i -> i.equalsIgnoreCase(ingredient)))
                .collect(Collectors.toList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(allDrink);
    }

    @Override
    public String toString() {
        return "Drinks list:\n\n\n" + allDrink + "\n";
    }
}
