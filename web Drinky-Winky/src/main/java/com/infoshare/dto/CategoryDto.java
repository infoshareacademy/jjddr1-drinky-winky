package com.infoshare.dto;

import com.infoshare.model.Category;
import com.infoshare.model.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CategoryDto {

    private Long id;
    private String name;
    private List<DrinkDTO> drinkDTOS = new ArrayList<>();

    public CategoryDto categoryToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    public Category dtoToCategory (CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
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

    public List<DrinkDTO> getDrinkDTOS() {
        return drinkDTOS;
    }

    public void setDrinkDTOS(List<DrinkDTO> drinkDTOS) {
        this.drinkDTOS = drinkDTOS;
    }
}
