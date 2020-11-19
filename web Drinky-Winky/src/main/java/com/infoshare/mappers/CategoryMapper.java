package com.infoshare.mappers;

import com.infoshare.model.Category;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class CategoryMapper {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Category mapCategory(DrinkAPI drinkAPI) {
        Category category = new Category();
        category.setName(drinkAPI.getCategory());
        logger.info("Category " + category.getName() + " mapped");
        return category;
    }
}
