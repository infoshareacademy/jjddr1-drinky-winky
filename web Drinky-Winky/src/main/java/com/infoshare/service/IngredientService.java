package com.infoshare.service;

import com.infoshare.dao.IngredientDAO;
import com.infoshare.dto.IngredientDTO;
import com.infoshare.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class IngredientService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    IngredientDAO ingredientDAO;

    public void saveIngredient(IngredientDTO ingredientDTO) {
        ingredientDAO.saveIngredient(ingredientDTO);
        logger.info("Ingredient has been saved");
    }

    public Ingredient editIngredient(IngredientDTO ingredientDTO){
        return ingredientDAO.editIngredient(ingredientDTO.getId(), ingredientDTO);
    }

    public Ingredient findIngredientById(Long id) {
        return ingredientDAO.findIngredientById(id);
    }

    public Ingredient findIngredientByName(String name) {
        logger.info("Get specific ingredient by its name");
        return ingredientDAO.findIngredientByName(name);
    }

    public Ingredient updateIngredient(Long id, IngredientDTO ingredientDTO) {
        return ingredientDAO.editIngredient(id, ingredientDTO);
    }

    public void remove(Long id) {
        ingredientDAO.removeIngredient(id);
        logger.info("Ingredient has been removed");
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientDAO.getListOfIngredients();
    }
}
