package com.infoshare.dao;

import com.infoshare.dto.IngredientDTO;
import com.infoshare.model.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class IngredientDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Ingredient findIngredientById(Long id) {
        return entityManager.find(Ingredient.class, id);
    }

    public Ingredient findIngredientByName(String name){
        return entityManager.find(Ingredient.class, name);
    }

    public IngredientDTO saveIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = IngredientDTO.createModelFromIngredientsDTO(ingredientDTO);
        entityManager.persist(ingredient);
        return IngredientDTO.createIngredientsDTOFromModel(ingredient);
    }

    public Ingredient editIngredient(Long id, IngredientDTO ingredientDTO) {
        Ingredient toEdit = entityManager.find(Ingredient.class, id);
        if (toEdit != null) {
            toEdit.setIngredientName(ingredientDTO.getIngredientName());
            toEdit.setMeasurement(ingredientDTO.getMeasurement());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean removeIngredient(Long id) {
        Ingredient toRemove = entityManager.find(Ingredient.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public List<Ingredient> getListOfIngredients() {
        TypedQuery<Ingredient> query = entityManager.createQuery("SELECT d FROM Drink d", Ingredient.class);
        return query.getResultList();
    }
}
