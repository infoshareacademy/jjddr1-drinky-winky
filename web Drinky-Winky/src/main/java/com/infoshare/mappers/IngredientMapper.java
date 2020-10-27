package com.infoshare.mappers;

import com.infoshare.model.Ingredient;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class IngredientMapper {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public List<Ingredient> mapIngredients(DrinkAPI drinkAPI) {


        List<Ingredient> ingredients = new ArrayList<>();

        drinkAPI.getIngredients().entrySet().forEach( i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(i.getKey());
            ingredient.setMeasure(i.getValue());
            ingredients.add(ingredient);
        });
        logger.info("Ingredients are added.");
        return ingredients;

    }
}
