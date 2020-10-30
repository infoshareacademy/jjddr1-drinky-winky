package com.infoshare.mappers;

import com.infoshare.dto.CategoryDto;
import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DrinkMapper {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
@EJB
private IngredientMapper ingredientMapper;
    
    public Drink mapRecipes(DrinkAPI drinkAPI, Category category) {

        Drink drink = new Drink();
        drink.setId(drinkAPI.getId());
        drink.setName(drinkAPI.getName());
        drink.setDrinkType(drinkAPI.getDrinkType());
        drink.setGlassType(drinkAPI.getGlassType());
        drink.setRecipe(drinkAPI.getRecipe());
        drink.getIngredientList().addAll(ingredientMapper.mapIngredients(drinkAPI));
        drink.setModificationDate(drinkAPI.getModificationDate());
        drink.setImageUrl(drinkAPI.getImageUrl());
        drink.setCategory(category);
        drink.setCustom(false);
        drink.setApproved(true);
        logger.info("Drink is mapped");
        return drink;
    }
}
