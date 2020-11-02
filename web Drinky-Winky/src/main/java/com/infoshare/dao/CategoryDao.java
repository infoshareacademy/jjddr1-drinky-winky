package com.infoshare.dao;

import com.infoshare.model.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;


    public Category saveCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    public Category updateCategory(Category category) {
        return entityManager.merge(category);
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

    public String[] getCategoryIds() {
        Query query = entityManager.createNamedQuery("Category.getCategoryIds");

        List<Long> ListaIds = query.getResultList();
        String[] tablica = new String[ListaIds.size()];
        for (int i = 0; i < ListaIds.size(); i++) {
            tablica[i] = ListaIds.get(i).toString();
        }
        return tablica;
    }
}

