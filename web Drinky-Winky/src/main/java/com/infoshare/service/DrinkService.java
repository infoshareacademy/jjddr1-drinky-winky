package com.infoshare.service;

import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.CategoryDto;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.dto.IngredientDTO;
import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;
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
    }

    public void addDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
        drinkDao.addDrink(drink); }

    public void editDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
        DrinkDTO.drinkToDTO(drink);
    }

    public Drink getDrinkByName(String name) {
        return drinkDao.getDrinkByName(name);
    }

    public Drink getDrinkById(Long id) {
        return drinkDao.getDrinkById(id);
    }

    public void deleteRecipeById(Long id) {
        drinkDao.deleteRecipeById(id);
        logger.info("Category has been deleted");
    }

    public List<Drink> getRecipesList() {
        return drinkDao.getDrinkList();
    }

    public List<String> findDrinkByCategoryIdAndIngredient(List<Long> ids, List<String> names) {
        return drinkDao.findDrinkByCategoryIdAndIngredient(ids, names);
    }
}
