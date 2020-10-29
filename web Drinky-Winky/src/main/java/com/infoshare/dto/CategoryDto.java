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

    public static Function<CategoryDto, Category> DtoToCategory = new Function<CategoryDto, Category>() {
        @Override
        public Category apply(CategoryDto categoryDto) {
            return new Category(categoryDto.getName(), categoryDto.getDrinkDTOS());
        }
    };

    public static Function<Category, CategoryDto> CategoryToDto = new Function<Category, CategoryDto>() {
        @Override
        public CategoryDto apply(Category category) {
            return new CategoryDto(category.getName(), category.getDrinkList());
        }
    };

    public CategoryDto(String name, List<DrinkDTO> drinkDTOS) {
        this.name = name;
        this.drinkDTOS = drinkDTOS;
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
