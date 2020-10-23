package com.infoshare.dto;

import com.infoshare.model.Ingredient;

import javax.validation.constraints.NotNull;

public class IngredientDTO {
    private String id;
    private String ingredientName;
    private String measurement;


    public static IngredientDTO createIngredientsDTOFromModel(@NotNull Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setMeasurement(ingredient.getMeasurement());
        ingredientDTO.setIngredientName(ingredient.getIngredientName());
        return ingredientDTO;
    }

    public static Ingredient createModelFromIngredientsDTO(@NotNull IngredientDTO ingredientDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setMeasurement(ingredientDTO.getMeasurement());
        ingredient.setIngredientName(ingredientDTO.getIngredientName());
        return ingredient;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public IngredientDTO() {

    }


}
