package com.infoshare.dto;

import com.infoshare.model.Category;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    private Long id;
    private String categoryName;

    public static CategoryDTO createCategoryDTOFromModel(@NotNull Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName());
        return categoryDTO;
    }

    public static Category createModelFromCategoryDTO(@NotNull CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
