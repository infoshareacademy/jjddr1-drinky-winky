package com.infoshare.dto;

import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DrinkDTO {
    //<--- TODO bibiolteki ktore automatycznie mapuja jedna klas na druga
//    poczytac o Lombock, plugin i dependecy sa potrzebne
    private Long id;
    private String drinkName;
    private String recipeName;
    private String isAlcoholic;
    private String dateModified;
    private String glass;
    private String categoryName;
    private String ingredientName;
    private List<Ingredient> ingredients;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public DrinkDTO() {
    }

    public static DrinkDTO createDTOFromModel(@NotNull Drink drink) {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setDrinkName(drink.getDrinkName());
        drinkDTO.setIngredients(drink.getIngredients());
        drinkDTO.setCategoryName(drink.getCategoryName());
        drinkDTO.setDateModified(drink.getDateModified());
        drinkDTO.setGlass(drink.getGlass());
        drinkDTO.setIsAlcoholic(drink.getIsAlcoholic());
        drinkDTO.setRecipeName(drink.getRecipeName());
        drinkDTO.setIngredientName(drink.getIngredientName());
        return drinkDTO;
    }

    public static Drink createModelFromDTO(@NotNull DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setDrinkName(drinkDTO.getDrinkName());
        drink.setIngredients(drinkDTO.getIngredients());
        drink.setCategoryName(drinkDTO.getCategoryName());
        drink.setDateModified(drinkDTO.getDateModified());
        drink.setGlass(drinkDTO.getGlass());
        drink.setIsAlcoholic(drinkDTO.getIsAlcoholic());
        drink.setRecipeName(drinkDTO.getRecipeName());
        drink.setIngredientName(drinkDTO.getIngredientName());
        return drink;
    }

    @Override
    public String toString() {
        return "DrinkDTO{" +
                "id=" + id +
                ", drinkName='" + drinkName + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", isAlcoholic='" + isAlcoholic + '\'' +
                ", dateModified='" + dateModified + '\'' +
                ", glass='" + glass + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
