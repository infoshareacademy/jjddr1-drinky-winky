package com.infoshare.service;

import com.infoshare.dao.IngredientDao;
import com.infoshare.dto.IngredientDTO;
import com.infoshare.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class IngredientService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private IngredientDao ingredientDao;

    public void addIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = IngredientDTO.dtoToIngredient(ingredientDTO);
        ingredientDao.addIngredient(ingredient);
    }

    public void editIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = IngredientDTO.dtoToIngredient(ingredientDTO);
        ingredientDao.editIngredient(ingredient);
    }

    public Ingredient getIngredientByName(String name) {
        logger.info("Get Ingredient by name");
        return ingredientDao.getIngredientByName(name);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientDao.getIngredientById(id);
    }

    public void deleteCategoryById(Long id) {
        ingredientDao.deleteIngredientById(id);
    }


    @Transactional
    public List<IngredientDTO> getIngredientsList() {
        return ingredientDao.getIngredientsList()
                .stream()
                .map(IngredientDTO::ingredientToDto)
                .collect(Collectors.toList());
    }
}

