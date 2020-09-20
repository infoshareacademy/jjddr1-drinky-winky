package com.infoshare.drinkywinky.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {

    private final String id;
    private final String name;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private final String category;
    private List<String> ingredients = new ArrayList<>();
    private String fakeIngredient;


    public Drink(@JsonProperty("idDrink") String id,
                 @JsonProperty("strDrink") String name,
                 @JsonProperty("strCategory") String category
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
    }


    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6"})
    public String getFakeIngredient() {
        return fakeIngredient;
    }

    @JsonSetter()
    public void setFakeIngredient(String ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
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

    @Override
    public String toString() {
        return "Drink name : " + name +
                ", SearchByCategory : " + category + ",\nIngredients : \n" + ingredients +
                " ,"+ " idDrink : " + id +".\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink)) return false;
        Drink drink = (Drink) o;
        return Objects.equals(getId(), drink.getId()) &&
                Objects.equals(getName(), drink.getName()) &&
                Objects.equals(getCategory(), drink.getCategory()) &&
                Objects.equals(getIngredients(), drink.getIngredients()) &&
                Objects.equals(getFakeIngredient(), drink.getFakeIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getIngredients(), getFakeIngredient());
    }
}
