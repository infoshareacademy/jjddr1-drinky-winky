package com.infoshare.service;

import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class DrinkService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    DrinkDao drinkDao;

    public void loadDrinks(List<Drink> drinks) {
        drinkDao.loadDrink(drinks);
        logger.info("Drinks list has been loaded");
    }
    public void addDrink(DrinkDTO drinkDTO) {
        drinkDao.addDrink(drinkDTO);
        logger.info("Drink has been saved");
    }
    public Drink editDrink(DrinkDTO drinkDTO) {
        logger.info("Drink updated.");
        return drinkDao.editDrink(drinkDTO);
    }
    public Drink getDrinkByName(String name) {
        logger.info("Get drink by name");
        return drinkDao.getDrinkByName(name);
    }
    public Drink getDrinkById(Long id) {
        logger.info("Get drink by id");
        return drinkDao.getDrinkById(id);
    }
    public void deleteRecipeById(Long id) {
        drinkDao.deleteRecipeById(id);
        logger.info("Category has been deleted");
    }
    public List<Drink> getRecipesList() {
        logger.info("Get drinks list");
        return drinkDao.getDrinkList();
    }

    public List<String> findDrinkByCategoryIdAndIngredient(List<Long> ids, List<String> names) {
        return drinkDao.findDrinkByCategoryIdAndIngredient(ids, names);
    }
}
