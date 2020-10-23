package com.infoshare.dao;


import com.infoshare.dto.RecipeDTO;
import com.infoshare.model.Recipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RecipeDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Recipe findById(Long id) {
        return entityManager.find(Recipe.class, id);
    }

    public RecipeDTO saveDrink(RecipeDTO recipeDTO) {
        Recipe recipe = RecipeDTO.createModelFromRecipeDTO(recipeDTO);
        entityManager.persist(recipe);
        return RecipeDTO.createRecipeDTOFromModel(recipe);
    }

    public Recipe edit(Long id, Recipe recipe) {
        Recipe toEdit = entityManager.find(Recipe.class, id);
        if (toEdit != null) {
            toEdit.setId(recipe.getId());
            toEdit.setRecipeName(recipe.getRecipeName());
            toEdit.setGlass(recipe.getGlass());
            toEdit.setIsAlcoholic(recipe.getIsAlcoholic());
            toEdit.setDateModified(recipe.getDateModified());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean remove(Long id) {
        Recipe toRemove = entityManager.find(Recipe.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public List<Recipe> getRecipeList() {
        TypedQuery<Recipe> query = entityManager.createQuery("SELECT r FROM Recipe r", Recipe.class);
        return query.getResultList();
    }
}
