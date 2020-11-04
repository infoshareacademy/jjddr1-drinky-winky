package com.infoshare.service;

import com.infoshare.dao.CategoryDao;
import com.infoshare.dto.CategoryDto;
import com.infoshare.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
        categoryDao.updateCategory(category);
    }

    public Category getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    @Transactional
    public List<CategoryDto> getCategoriesList() {
        return categoryDao.getCategoriesList()
                .stream()
                .map(category -> CategoryDto.categoryToDto(category))
                .collect(Collectors.toList());
    }

    @Transactional
    public Category findCategoryByName(String name) {
        return categoryDao.findCategoryByName(name);
    }

    public String[] getCategoryIds() {
        return categoryDao.getCategoryIds();
    }

}
