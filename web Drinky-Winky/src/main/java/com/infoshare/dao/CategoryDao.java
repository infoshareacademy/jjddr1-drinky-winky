package com.infoshare.dao;

import com.infoshare.dto.CategoryDto;
import com.infoshare.dto.IngredientDTO;
import com.infoshare.model.Category;
import com.infoshare.model.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;


    public void saveCategory(CategoryDto categorydto) {
        Category category = CategoryDto.dtoToCategory(categorydto);
        entityManager.persist(category);
    }

    public Ingredient editIngredient(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredientToUpdate = entityManager.find(Ingredient.class, id);
        if (ingredientToUpdate != null) {
            ingredientToUpdate.setMeasure(ingredientDTO.getMeasure());
            ingredientToUpdate.setName(ingredientDTO.getName());
        }
        return entityManager.merge(ingredientToUpdate);
    }

    public Category updateCategory(CategoryDto categoryDto) {
        Category categoryToUpdate = entityManager.find(Category.class, categoryDto);
        if (categoryToUpdate != null) {
            categoryToUpdate.setName(categoryDto.getName());
        }
        return entityManager.merge(categoryToUpdate);
    }

    public Category getCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> getCategoriesList() {
        Query query = entityManager.createNamedQuery("Category.getCategoryList");
        return query.getResultList();
    }

    public Category findCategoryByName(String name) {
        Query query = entityManager.createNamedQuery("Category.findCategoryByName");
        query.setParameter("name", name);
        return (Category) query.getResultList().stream().findFirst().orElse(null);
    }
}

