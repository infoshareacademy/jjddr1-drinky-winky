package com.infoshare.dao;

import com.infoshare.dto.IngredientDTO;
import com.infoshare.dto.UserDTO;
import com.infoshare.model.Ingredient;
import com.infoshare.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class IngredientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void loadIngredient(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            entityManager.persist(ingredient);
        }
    }

    public void addIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = IngredientDTO.dtoToIngredient(ingredientDTO);
        entityManager.persist(ingredient);
    }

    public Ingredient editIngredient(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredientToUpdate = entityManager.find(Ingredient.class, id);
        if (ingredientToUpdate != null) {
            ingredientToUpdate.setMeasure(ingredientDTO.getMeasure());
            ingredientToUpdate.setName(ingredientDTO.getName());
        }
        return entityManager.merge(ingredientToUpdate);
    }

    public Ingredient getIngredientByName(String name) {
        return entityManager.find(Ingredient.class, name);
    }

    public Ingredient getIngredientById(Long id) {
        return entityManager.find(Ingredient.class, id);
    }

    public void deleteIngredientById(Long id) {
        Ingredient ingredient = getIngredientById(id);
        if (ingredient != null) {
            entityManager.remove(ingredient);
        }
    }

    public Ingredient findIngredient(String names) {
        Query query = entityManager.createNamedQuery("Ingredient.findIngredientByName");
        query.setParameter("names", names);
        return (Ingredient) query.getSingleResult();
    }

    public List<String> getIngredientsList() {
        Query query = entityManager.createNamedQuery("Ingredient.getIngredientList");
        return query.getResultList();
    }
}
