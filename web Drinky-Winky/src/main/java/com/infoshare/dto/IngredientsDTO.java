package com.infoshare.dto;

import com.infoshare.model.Ingredient;

import javax.validation.constraints.NotNull;

public class IngredientsDTO {
    private String id;
    private String ingredientsName;
    private String measuerement;


    public static IngredientsDTO createIngredientsDTOFromModel(@NotNull Ingredient ingredient) {
        IngredientsDTO ingredientsDTO = new IngredientsDTO();
        ingredientsDTO.setMeasuerement(ingredient.getMeasurement());
        ingredientsDTO.setIngredientsName(ingredient.getIngredientName());
        return ingredientsDTO;
    }

    public static Ingredient createModelFromIngredientsDTO(@NotNull IngredientsDTO ingredientsDTO){
        Ingredient ingredient = new Ingredient();
        ingredient.setMeasurement(ingredientsDTO.getMeasuerement());
        ingredient.setIngredientName(ingredientsDTO.getIngredientsName());
        return ingredient;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public String getMeasuerement() {
        return measuerement;
    }

    public void setMeasuerement(String measuerement) {
        this.measuerement = measuerement;
    }

    public IngredientsDTO() {

    }


}
