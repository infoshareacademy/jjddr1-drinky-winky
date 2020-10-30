package com.infoshare.service;

import com.infoshare.dao.CategoryDao;
import com.infoshare.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private CategoryDao categoryDao;

    public void save(Category category) {
        categoryDao.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    public List<Category> getCategoriesList() {
        return categoryDao.getCategoriesList();
    }

    public Category findCategoryByName(String name) {
        return categoryDao.findCategoryByName(name);
    }

}
