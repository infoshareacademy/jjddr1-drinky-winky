package com.infoshare.dto;

import com.infoshare.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class IngredientDTO {

    private Long id;
    private String name;
    private List<DrinkDTO> drinkDTOS = new ArrayList<>();

    public static Function<IngredientDTO, Ingredient> DtoToIngredient = new Function<IngredientDTO, Ingredient>() {
        @Override
        public Ingredient apply(IngredientDTO ingredientDTO) {
            return new Ingredient(ingredientDTO.getName(), ingredientDTO.getDrinkDTOS());
        }
    };

    public static Function<Ingredient, IngredientDTO> IngredientToDto = new Function<Ingredient, IngredientDTO>() {
        @Override
        public IngredientDTO apply(Ingredient ingredient) {
            return new IngredientDTO(ingredient.getName(), ingredient.getDrinkList());
        }
    };

    public IngredientDTO() {
    }

    public IngredientDTO(String name, List<DrinkDTO> drinkDTOS) {
        this.name = name;
        this.drinkDTOS = drinkDTOS;
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

    public List<DrinkDTO> getDrinkDTOS() {
        return drinkDTOS;
    }

    public void setDrinkDTOS(List<DrinkDTO> drinkDTOS) {
        this.drinkDTOS = drinkDTOS;
    }
}
