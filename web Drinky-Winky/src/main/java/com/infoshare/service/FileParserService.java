package com.infoshare.service;

import com.infoshare.dao.CategoryDao;
import com.infoshare.mappers.CategoryMapper;
import com.infoshare.mappers.DrinkMapper;
import com.infoshare.model.Category;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Transactional
@RequestScoped
public class FileParserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private ParserService parserService;

    @EJB
    private DrinkMapper drinkMapper;

    @EJB
    private CategoryMapper categoryMapper;

    @EJB
    private CategoryDao categoryDao;

    public Object parseDataToDatabase(File json) {
        List<DrinkAPI> drinkAPIS = (List<DrinkAPI>) parserService.parseFile(json);
        for (DrinkAPI drinkAPI : drinkAPIS) {
            Category category = Optional
                    .ofNullable(categoryDao.findCategoryByName(drinkAPI.getRecipeCategory())).orElseGet(() -> categoryMapper.mapCategory(drinkAPI));
            category.getDrinkList().add(drinkMapper.mapRecipes(drinkAPI,category));
            categoryDao.updateCategory(category);
        }
        logger.info("file was parsed");
        return null;
    }
}
