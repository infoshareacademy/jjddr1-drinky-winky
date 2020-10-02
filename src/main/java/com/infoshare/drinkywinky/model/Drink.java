package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink implements Comparable<Drink> {
    private final String id;
    private final String name;
    private final String category;
    private final String recipe;
    private final String alcoholic;
    private final String dateModified;
    private final String glass;

    private List<String> ingredients = new ArrayList<>();

    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6"})
    public String getFakeIngredient() {
        return null;
    }

    @JsonSetter()
    public void setFakeIngredient(String ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    public Drink(@JsonProperty("idDrink") String id,
                 @JsonProperty("strDrink") String name,
                 @JsonProperty("strCategory") String category,
                 @JsonProperty("strInstructions") String recipe,
                 @JsonProperty("strAlcoholic") String alcoholic,
                 @JsonProperty("dateModified") String datemodified,
                 @JsonProperty("strGlass") String glass

    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.alcoholic = alcoholic;
        this.dateModified = datemodified;
        this.glass = glass;
    }

    public Drink(String id, String name, String category, String recipe, String alcoholic, String datemodified, String glass, List<String> ingredients) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.alcoholic = alcoholic;
        this.dateModified = datemodified;
        this.glass = glass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public String getDatemodified() {
        return dateModified;
    }

    public String getGlass() {
        return glass;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "\nDrink name: " + name +
                "\nCategory: " + category + "\nIngredients: " + ingredients +
                "\nID: " + id + "\nRecipe: \n" + recipe + "\nAlcoholic: " + alcoholic +
                "\nGlass type: " + glass + "\nDate of modification: "
                + dateModified + "\n";
    }

    @Override
    public int compareTo(Drink o) {
        return name.compareToIgnoreCase(o.getName());
    }
}
