package com.infoshare.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
public class Drink {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String glass;

    @Column
    private String alcohol;

    @Column
    private String recipe;


//    private List<String> ingredient;
//    private List<String> measure;


    public Drink() {
    }

    public Drink(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }


    //    public List<String> getIngredient() {
//        return ingredient;
//    }
//
//    public List<String> getMeasure() {
//        return measure;
//    }

    public static List<Drink> getDrink() {
        return Arrays.asList(
                new Drink("Margarita"),
                new Drink("Cola"),
                new Drink("Mocarz"),
                new Drink("Spirit")
        );
    }
}
