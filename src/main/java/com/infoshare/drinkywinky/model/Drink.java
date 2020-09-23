package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {
    private final String id;
    private final String name;
    private final String category;
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
                 @JsonProperty("strCategory") String category
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Drink(String id, String name, String category, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Drink name: " + name +
                "\nCategory: " + category + "\nIngredients: " + ingredients +
                "\nID: " + id + "\n";
    }
}
