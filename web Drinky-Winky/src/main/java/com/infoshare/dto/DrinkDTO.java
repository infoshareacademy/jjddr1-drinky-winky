package com.infoshare.dto;


import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DrinkDTO {

    private Long id;
    private String name;
    private String category;
    private String recipe;
    private String alcoholic;
    private String dateModified;
    private String glass;
    private List<Ingredient> ingredients;


    public DrinkDTO() {
    }


    public static DrinkDTO createDTOFromModel(@NotNull Drink drink) {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getName());
        drinkDTO.setCategory(drink.getCategory());
        drinkDTO.setRecipe(drink.getRecipe());
        drinkDTO.setGlass(drink.getGlass());
        drinkDTO.setDateModified(drink.getDateModified());
        drinkDTO.setAlcoholic(drink.getAlcoholic());
        return drinkDTO;
    }

    public static Drink createModelFromDTO(@NotNull DrinkDTO drinkDTO){
        Drink drink = new Drink();
        drink.setId(drinkDTO.getId());
        drink.setName(drinkDTO.getName());
        drink.setCategory(drinkDTO.getCategory());
        drink.setRecipe(drinkDTO.getRecipe());
        drink.setGlass(drinkDTO.getGlass());
        drink.setDateModified(drinkDTO.getDateModified());
        drink.setAlcoholic(drinkDTO.getAlcoholic());
        return drink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

}
