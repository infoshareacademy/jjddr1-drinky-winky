package com.infoshare.dao;

import com.infoshare.dto.IngredientsDTO;
import com.infoshare.model.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class IngredientsDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Ingredient findById(Integer id) {
        return entityManager.find(Ingredient.class, id);
    }

    public IngredientsDTO saveDrink(IngredientsDTO ingredientsDTO) {
        Ingredient ingredient = IngredientsDTO.createModelFromIngredientsDTO(ingredientsDTO);
        entityManager.persist(ingredient);
        return IngredientsDTO.createIngredientsDTOFromModel(ingredient);
    }

    public Ingredient edit(Integer id, Ingredient ingredient) {
        Ingredient toEdit = entityManager.find(Ingredient.class, id);
        if (toEdit != null) {
            toEdit.setId(ingredient.getId());
            toEdit.setIngredientName(ingredient.getIngredientName());
            toEdit.setMeasurement(ingredient.getMeasurement());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Ingredient toRemove = entityManager.find(Ingredient.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public List<Ingredient> getAll() {
        TypedQuery<Ingredient> query = entityManager.createQuery("SELECT d FROM Drink d", Ingredient.class);
        return query.getResultList();
    }
}
