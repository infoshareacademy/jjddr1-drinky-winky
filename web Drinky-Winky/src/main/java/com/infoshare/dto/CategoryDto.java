package com.infoshare.dto;

import com.infoshare.model.Category;
import com.infoshare.model.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CategoryDto {

    private Long id;
    private String name;
    private List<Drink> drinkList = new ArrayList<>();

    public static CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDrinkList(category.getDrinkList());
        return categoryDto;
    }

    public static Category dtoToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDrinkList(categoryDto.getDrinkList());
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
}
