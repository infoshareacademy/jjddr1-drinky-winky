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
    private String dateModified;
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
                 @JsonProperty("strGlass") String glass,


                 List<String> ingredientsList) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.alcoholic = alcoholic;
        this.dateModified = dateModified;
        this.glass = glass;
    }

    public Drink(String id, String name, String category, String recipe, String alcoholic, String glass, List<String> ingredients, List<String> measures) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.alcoholic = alcoholic;
//        this.dateModified = dateModified;
//        String dateModified
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
        return dateModified;
    }

    public String getGlass() {
        return glass;
    }

    public List<String> getIngredients() {
        List<String> strings = new ArrayList<>();

        if (ingredients.size() == measures.size()) {
            System.out.println("jestesmy w ifie");
            for (int i = 0; i < ingredients.size(); i++) {
                String s = ingredients.get(i);
                String s1 = measures.get(i);
                String s3 = s.concat(s1);
                strings.add(s3);
            }
        } else {
            for (int i = 0; i < measures.size(); i++) {
                String s4 = ingredients.get(i + 1);
                String s5 = measures.get(i);
                String concat = s4.concat(s5);
                strings.add(concat);
            }
            String salt = ingredients.get(0);
            strings.add(salt);
        }

        return strings;
    }

    public List<String> getMeasures() {
        return measures;
    }

    @Override
    public String toString() {


        return "\nDrink name: " + name + "\nCategory: " + category + "\nIngredients and measures: " + getIngredients()
                + "\nID: " + id + "\nRecipe: \n" + recipe + "\nAlcoholic: " + alcoholic + "\nGlass type: "
                + glass + "\nDate of modification: " + dateModified + "\n";
    }

    @Override
    public int compareTo(Drink o) {
        return name.compareToIgnoreCase(o.getName());
    }
}

//    public String toString() {
//        StringBuilder sb = new StringBuilder("The Social Security Numbers you entered are:\n");
//        for (int i = 0; i < ingredients.size(); i++) {
//            sb.append(ingredients[i]).append("\n");
//        }
//        return sb.toString();
//    }