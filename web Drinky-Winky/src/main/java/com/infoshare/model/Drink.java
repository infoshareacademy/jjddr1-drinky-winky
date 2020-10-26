package com.infoshare.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Drink {

    private String name;
    private String category;
    private String glass;
    private String alcohol;
    private String recipe;
    private List<String> ingredient;
    private List<String> measure;

    public Drink(String name, String category, String glass, String alcohol, String recipe, List<String> ingredient, List<String> measure) {
        this.name = name;
        this.category = category;
        this.glass = glass;
        this.alcohol = alcohol;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getGlass() {
        return glass;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public String getRecipe() {
        return recipe;
    }

    public List<String> getIngredient() {
        return ingredient;
    }

    public List<String> getMeasure() {
        return measure;
    }

    public static List<Drink> getDrink() {
        return Arrays.asList(
                new Drink("Margarita"),
                new Drink("Cola"),
                new Drink("Mocarz"),
                new Drink("Spirit")
        );
    }
}
