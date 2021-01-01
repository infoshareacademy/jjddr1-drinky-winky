package com.infoshare.mappers;

import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DrinkMapper {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    @EJB
    private IngredientMapper ingredientMapper;

    public Drink mapRecipes(DrinkAPI drinkAPI, Category category) {

        Drink drink = Drink.builder()
                .id(drinkAPI.getId())
                .name(drinkAPI.getName())
                .drinkType(drinkAPI.getDrinkType())
                .glassType(drinkAPI.getGlassType())
                .recipe(drinkAPI.getRecipe())
                .ingredientList(ingredientMapper.mapIngredients(drinkAPI))
                .modificationDate(drinkAPI.getModificationDate())
                .imageUrl(drinkAPI.getImageUrl())
                .category(category)
                .isCustom(false)
                .isApproved(true)
                .build();
        logger.info("Drink {} mapped", drink.getName());
        return drink;
    }
}
