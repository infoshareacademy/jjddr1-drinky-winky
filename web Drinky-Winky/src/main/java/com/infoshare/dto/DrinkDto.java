package com.infoshare.dto;

import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DrinkDto {
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
    private List<IngredientDto> ingredientList;

    public static DrinkDto drinkToDTO(Drink drink) {
        DrinkDto drinkDTO = new DrinkDto();
        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getName());
        drinkDTO.setIsCustom(drink.getIsCustom());
        drinkDTO.setIsApproved(drink.getIsApproved());
        drinkDTO.setRecipe(drink.getRecipe());
        drinkDTO.setDrinkType(drink.getDrinkType());
        drinkDTO.setGlassType(drink.getGlassType());
        drinkDTO.setModificationDate(drink.getModificationDate());
        drinkDTO.setImageUrl(drink.getImageUrl());
        drinkDTO.setCategory(CategoryDto.categoryToDto(drink.getCategory()));

        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        drink.getIngredientList().forEach(ingredient -> {
            IngredientDto ingredientDTO = IngredientDto.ingredientToDto(ingredient);
            ingredientDtoList.add(ingredientDTO);
                });
        drinkDTO.setIngredientList(ingredientDtoList);
        return drinkDTO;
    }

    public static Drink dtoToDrink(DrinkDto drinkDTO) {
        Drink drink = new Drink();
        drink.setName(drinkDTO.getName());
        drink.setIsCustom(drinkDTO.getIsCustom());
        drink.setIsApproved(drinkDTO.getIsApproved());
        drink.setRecipe(drinkDTO.getRecipe());
        drink.setDrinkType(drinkDTO.getDrinkType());
        drink.setGlassType(drinkDTO.getGlassType());
        drink.setModificationDate(drinkDTO.getModificationDate());
        drink.setImageUrl(drinkDTO.getImageUrl());
        drink.setCategory(CategoryDto.dtoToCategory(drinkDTO.getCategory()));

        List<Ingredient> ingredientList = new ArrayList<>();
        drinkDTO.getIngredientList().forEach(ingredientDto -> {
            Ingredient ingredient = IngredientDto.dtoToIngredient(ingredientDto);
            ingredientList.add(ingredient);
        });
        drink.setIngredientList(ingredientList);
        return drink;
    }
}

