package com.infoshare.dto;

import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;
import com.infoshare.model.User;

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
    private Category category;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private List<User> users = new ArrayList<>();


    public static Function<DrinkDTO, Drink> DtoToDrink = new Function<DrinkDTO, Drink>() {
        @Override
        public Drink apply(DrinkDTO drinkDTO) {
            return new Drink(drinkDTO.getName(), drinkDTO.getCustom(), drinkDTO.getApproved(), drinkDTO.getRecipe(),
                            drinkDTO.getDrinkType(), drinkDTO.getGlassType(), drinkDTO.getModificationDate(),
                            drinkDTO.getImageUrl(), drinkDTO.getCategory(), drinkDTO.getIngredientList(),
                            drinkDTO.getUsers());
        }
    };

    public static Function<Drink, DrinkDTO> DrinkToDto = new Function<Drink, DrinkDTO>() {
        @Override
        public DrinkDTO apply(Drink drink) {
            return new DrinkDTO(drink.getName(), drink.getCustom(), drink.getApproved(), drink.getRecipe(),
                                drink.getDrinkType(), drink.getGlassType(), drink.getModificationDate(),
                                drink.getImageUrl(), drink.getCategory(), drink.getIngredientList(),
                                drink.getUsers());
        }
    };


    public DrinkDTO(String name, Boolean isCustom, Boolean isApproved, String recipe, String drinkType, String glassType,
                    String modificationDate, String imageUrl, Category category, List<Ingredient> ingredientList,
                    List<User> users) {
        this.name = name;
        this.isCustom = isCustom;
        this.isApproved = isApproved;
        this.recipe = recipe;
        this.drinkType = drinkType;
        this.glassType = glassType;
        this.modificationDate = modificationDate;
        this.imageUrl = imageUrl;
        this.category = category;
        this.ingredientList = ingredientList;
        this.users = users;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

