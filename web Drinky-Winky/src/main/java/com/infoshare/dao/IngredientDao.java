package com.infoshare.dao;

import com.infoshare.model.Ingredient;

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

    public Ingredient addIngredient(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }

    public Ingredient editIngredient(Ingredient ingredient) {
        entityManager.merge(ingredient);
        return ingredient;
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

    public List<Ingredient> getIngredientsList() {
        Query query = entityManager.createNamedQuery("Ingredient.getIngredientList");
        return query.getResultList();
    }
}
