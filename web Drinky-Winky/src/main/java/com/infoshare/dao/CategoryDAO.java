package com.infoshare.dao;

import com.infoshare.dto.CategoryDTO;
import com.infoshare.model.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CategoryDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public CategoryDTO saveDrink(CategoryDTO categoryDTO) {
        Category category = CategoryDTO.createModelFromCategoryDTO(categoryDTO);
        entityManager.persist(category);
        return CategoryDTO.createCategoryDTOFromModel(category);
    }

    public Category edit(Long id, Category category) {
        Category toEdit = entityManager.find(Category.class, id);
        if (toEdit != null) {
            toEdit.setId(category.getId());
            toEdit.setCategoryName(category.getCategoryName());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean remove(Long id) {
        Category toRemove = entityManager.find(Category.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public List<Category> getcategoryList() {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }
}
