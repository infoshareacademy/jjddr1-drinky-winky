package com.infoshare.service;

import com.infoshare.dao.IngredientDAO;
import com.infoshare.dto.IngredientDTO;
import com.infoshare.model.Ingredient;
import javax.inject.Inject;

public class IngredientService {

        @Inject
        IngredientDAO ingredientDAO;

        public IngredientDTO saveIngredient(IngredientDTO ingredientDTO) {
            return ingredientDAO.saveDrink(ingredientDTO);
        }

        public Ingredient findById(Long id) {
            return ingredientDAO.findById(id);
        }

        public Ingredient updateIngredient(Long id, IngredientDTO ingredientDTO) {
            return ingredientDAO.edit(id, ingredientDTO);
        }

        public boolean remove(Long id) {
            return ingredientDAO.remove(id);
        }
}
