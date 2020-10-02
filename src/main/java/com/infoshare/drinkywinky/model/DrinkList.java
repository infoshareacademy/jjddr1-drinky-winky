package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
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

    public List<Drink> getDrinkById(String id) {
        return allDrink
                .stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Drink> getDrinkByName(String name) {
        return allDrink
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Drink> getDrinkByCategory(String category) {
        return allDrink
                .stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Drink> getDrinkByIngredients(String ingredient) {
        return allDrink
                .stream()
                .filter(e ->
                        e.getIngredients().stream().anyMatch(i -> i.equalsIgnoreCase(ingredient)))
                .collect(Collectors.toList());
    }

    public List<Drink> getDrinkByRecipe(String recipe) {

        return allDrink
                .stream()
                .filter(e -> e.getRecipe()
                        .equalsIgnoreCase(recipe)).
                        collect(Collectors.toList());
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
