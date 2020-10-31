package com.infoshare.service;

import com.infoshare.dao.CategoryDao;
import com.infoshare.dto.CategoryDto;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Category;
import com.infoshare.model.Drink;
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

    public void saveCategory(CategoryDto categoryDto) {
        Category category = CategoryDto.dtoToCategory(categoryDto);
        categoryDao.saveCategory(category);
    }
    public void updateCategory(CategoryDto categoryDto) {
      Category category = CategoryDto.dtoToCategory(categoryDto);
      CategoryDto.categoryToDto(category);
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
