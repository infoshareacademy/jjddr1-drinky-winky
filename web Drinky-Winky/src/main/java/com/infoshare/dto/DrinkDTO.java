package com.infoshare.dto;

import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DrinkDTO {
    private Long id;
    private String name;
    private Boolean isCustom;
    private Boolean isApproved;
    private String recipe;
    private String drinkType;
    private String glassType;
    private String modificationDate;
    private String imageUrl;
    private CategoryDto category;
    private List<IngredientDTO> ingredientList;



    public static DrinkDTO drinkToDTO(Drink drink) {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getName());
        drinkDTO.setCustom(drink.getCustom());
        drinkDTO.setApproved(drink.getApproved());
        drinkDTO.setRecipe(drink.getRecipe());
        drinkDTO.setDrinkType(drink.getDrinkType());
        drinkDTO.setGlassType(drink.getGlassType());
        drinkDTO.setModificationDate(drink.getModificationDate());
        drinkDTO.setImageUrl(drink.getImageUrl());
        drinkDTO.setCategory(CategoryDto.categoryToDto(drink.getCategory()));

        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        drink.getIngredientList().forEach(ingredient -> {
            IngredientDTO ingredientDTO = IngredientDTO.ingredientToDto(ingredient);
            ingredientDTOList.add(ingredientDTO);
                });
        drinkDTO.setIngredientList(ingredientDTOList);
        return drinkDTO;
    }

    public static Drink DtoToDrink(DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setName(drinkDTO.getName());
        drink.setCustom(drinkDTO.getCustom());
        drink.setApproved(drinkDTO.getApproved());
        drink.setRecipe(drinkDTO.getRecipe());
        drink.setDrinkType(drinkDTO.getDrinkType());
        drink.setGlassType(drinkDTO.getGlassType());
        drink.setModificationDate(drinkDTO.getModificationDate());
        drink.setImageUrl(drinkDTO.getImageUrl());
        drink.setCategory(CategoryDto.dtoToCategory(drinkDTO.getCategory()));

        List<Ingredient> ingredientList = new ArrayList<>();
        drinkDTO.getIngredientList().forEach(ingredientDTO -> {
            Ingredient ingredient = IngredientDTO.dtoToIngredient(ingredientDTO);
            ingredientList.add(ingredient);
        });
        drink.setIngredientList(ingredientList);
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

    public Boolean getCustom() {
        return isCustom;
    }

    public void setCustom(Boolean custom) {
        isCustom = custom;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public List<IngredientDTO> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientDTO> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString() {
        return "DrinkDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCustom=" + isCustom +
                ", isApproved=" + isApproved +
                ", recipe='" + recipe + '\'' +
                ", drinkType='" + drinkType + '\'' +
                ", glassType='" + glassType + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                ", ingredientList=" + ingredientList +
                '}';
    }
}

