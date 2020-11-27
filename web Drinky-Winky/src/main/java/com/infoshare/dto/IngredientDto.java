package com.infoshare.dto;

import com.infoshare.model.Ingredient;

public class IngredientDto {

    private Long id;
    private String name;
    private String measure;

    public static IngredientDto ingredientToDto(Ingredient ingredient) {
        IngredientDto ingredientDTO = new IngredientDto();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setMeasure(ingredient.getMeasure());
        return ingredientDTO;
    }

    public static Ingredient dtoToIngredient(IngredientDto ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDTO.getName());
        ingredient.setMeasure(ingredientDTO.getMeasure());
        return ingredient;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
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

}
