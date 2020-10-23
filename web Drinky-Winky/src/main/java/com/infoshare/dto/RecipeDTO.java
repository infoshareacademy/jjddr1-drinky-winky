package com.infoshare.dto;


import com.infoshare.model.Recipe;
import javax.validation.constraints.NotNull;

public class RecipeDTO {

    private Long id;
    private String recipeName;
    private String isAlcoholic;
    private String dateModified;
    private String glass;

    public static RecipeDTO createRecipeDTOFromModel(@NotNull Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setRecipeName(recipe.getRecipeName());
        recipeDTO.setGlass(recipe.getGlass());
        recipeDTO.setIsAlcoholic(recipe.getIsAlcoholic());
        recipeDTO.setDateModified(recipe.getDateModified());
        return recipeDTO;
    }

    public static Recipe createModelFromRecipeDTO(@NotNull RecipeDTO recipeDTO){
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeDTO.getRecipeName());
        recipe.setGlass(recipeDTO.getGlass());
        recipe.setDateModified(recipeDTO.getDateModified());
        recipe.setIsAlcoholic(recipeDTO.getIsAlcoholic());
        return recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(String isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
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
