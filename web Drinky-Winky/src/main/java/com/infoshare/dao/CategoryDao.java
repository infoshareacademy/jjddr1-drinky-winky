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


    public void saveCategory(CategoryDto categoryDto) {
        Category category = CategoryDto.dtoToCategory(categoryDto);
        entityManager.persist(category);
    }

    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        CategoryDto categoryToUpdate = entityManager.find(CategoryDto.class, id);
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

