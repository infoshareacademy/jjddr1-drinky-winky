package com.infoshare.dto;


import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DrinkDTO {

    private Long id;
    private String name;
    private List<Ingredient> ingredients;


    public DrinkDTO() {
    }


    public static DrinkDTO createDTOFromModel(@NotNull Drink drink) {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getDrinkName());
        drinkDTO.setIngredients(drink.getIngredients());
        return drinkDTO;
    }

    public static Drink createModelFromDTO(@NotNull DrinkDTO drinkDTO){
        Drink drink = new Drink();
        drink.setId(drinkDTO.getId());
        drink.setDrinkName(drinkDTO.getName());
        drink.setIngredients(drinkDTO.getIngredients());
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
