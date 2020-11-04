package com.infoshare.dao;

import com.infoshare.model.Category;
import com.infoshare.model.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class IngredientDao {

    @PersistenceContext
    EntityManager entityManager;

    public Ingredient addIngredient(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }

    public Ingredient editIngredient(Ingredient ingredient) {
        entityManager.merge(ingredient);
        return ingredient;
    }

    public Ingredient getIngredientByName(String name) {
        TypedQuery<Ingredient> query = entityManager.createQuery(Ingredient.FIND_INGREDIENT_BY_NAME, Ingredient.class);
        query.setParameter("name", name);
        return query.getSingleResult();
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

    public List<Ingredient> getIngredientsList() {
        return entityManager.createNamedQuery(Ingredient.GET_INGREDIENT_LIST, Ingredient.class).getResultList();

    }

    public List<Ingredient> getIngredientsListNyDrinkName(String name){
        return null;
    }

}
