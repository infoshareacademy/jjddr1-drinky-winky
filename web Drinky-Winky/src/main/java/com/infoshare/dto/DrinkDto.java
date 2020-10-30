package com.infoshare.dto;

import com.infoshare.model.Drink;

import java.util.function.Function;

public class DrinkDto {

    private Integer id;
    private String name;
    private String category;
    private String glass;
    private String alcohol;
    private String recipe;

    public DrinkDto(Integer id, String name, String category, String glass, String alcohol, String recipe) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.glass = glass;
        this.alcohol = alcohol;
        this.recipe = recipe;
    }

    public DrinkDto(String name, String category, String glass, String alcohol, String recipe) {
        this.name = name;
        this.category = category;
        this.glass = glass;
        this.alcohol = alcohol;
        this.recipe = recipe;
    }

//    public static Function<DrinkDto, Drink> DtoToDrink = new Function<DrinkDto, Drink>() {
//        @Override
//        public Drink apply(DrinkDto drinkDto) {
//            return new Drink(drinkDto.getName(), drinkDto.getCategory(),
//                    drinkDto.getGlass(), drinkDto.getAlcohol(), drinkDto.getRecipe());
//        }
//    };
//
//    public static Function<Drink, DrinkDto> DrinkToDto = new Function<Drink, DrinkDto>() {
//        @Override
//        public DrinkDto apply(Drink drink) {
//            return new DrinkDto(drink.getId(), drink.getName(), drink.getCategory(), drink.getGlass(),
//                    drink.getAlcohol(), drink.getRecipe());
//        }
//    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
