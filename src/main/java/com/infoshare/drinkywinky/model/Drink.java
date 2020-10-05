package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import com.infoshare.drinkywinky.utils.Utils;
import com.infoshare.drinkywinky.properties.ConfigLoader;
import com.infoshare.drinkywinky.utils.DateFormatter;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> measures = new ArrayList<>();

    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6", "strIngredient7"})
    public String getFakeIngredient() {
        return null;
    }

    @JsonSetter()
    public void setFakeIngredient(String ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    @JsonAlias({"strMeasure1", "strMeasure2", "strMeasure3", "strMeasure4", "strMeasure5", "strMeasure6", "strMeasure7"})
    public String getFakeMeasure() {
        return null;
    }

    @JsonSetter()
    public void setFakeMeasure(String measure) {
        if (measure != null) {
            measures.add(measure);
        }
    }

    public Drink(@JsonProperty("idDrink") String id,
                 @JsonProperty("strDrink") String name,
                 @JsonProperty("strCategory") String category,
                 @JsonProperty("strInstructions") String recipe,
                 @JsonProperty("strAlcoholic") String alcoholic,
                 @JsonProperty("dateModified") String dateModified,
                 @JsonProperty("strGlass") String glass
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.alcoholic = alcoholic;
        this.dateModified = dateModified;
        this.glass = glass;
    }

    public Drink(String id,
                 String name,
                 String category,
                 String recipe,
                 String alcoholic,
                 String dateModified,
                 String glass,
                 List<String> ingredients,
                 List<String> measures
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.alcoholic = alcoholic;
        this.dateModified = dateModified;
        this.glass = glass;
        this.measures = measures;
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

    public String getDateModified() {
        DateFormatter formatter = new DateFormatter(ConfigLoader.DATE_FORMAT_KEY);
        formatter.getDateTime(dateModified);
        return formatter.getDateTime(dateModified);
    }

    public String getGlass() {
        return glass;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getMeasures() {
        return measures;
    }

    @Override
    public String toString() {
        return "\nDrink name: " + name + "\nCategory: " + category + "\nIngredients with measures: " +
                Utils.getIngredientsWithMeasures(ingredients, measures) +
                "\nID: " + id + "\nRecipe: \n" + recipe + "\nAlcoholic: " +
                alcoholic + "\nGlass type: " + glass + "\nDate of modification: " + dateModified + "\n";
    }

    @Override
    public int compareTo(Drink o) {
        return name.compareToIgnoreCase(o.getName());
    }
}
