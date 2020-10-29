package com.infoshare.dto;

import com.infoshare.model.Category;
import com.infoshare.model.Ingredient;
import com.infoshare.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DrinkDTO {
    private Long id;
    private String name;
    private Boolean isCustom;
    private Boolean isApproved;
    private String recipe;
    private String drinkType;
    private String glassType;
    private String modificationDate;
    private String imageUrl;
    private Category category;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public static Function<DrinkDTO, DrinkDao>

    public static Function<PersonDTO, Person> DTOtoPerson = new Function<PersonDTO, Person>() {
        @Override
        public Person apply(PersonDTO personDTO) {
            return new Person(personDTO.getId(), personDTO.getName(), personDTO.getLastName(), personDTO.getBirthdate());
        }
    };
    public static Function<Person, PersonDTO> PersonToDTO = new Function<Person, PersonDTO>() {
        @Override
        public PersonDTO apply(Person person) {
            return new PersonDTO(person.getName(), person.getLastName(), person.getBirthdate());
        }
    };

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

    public Boolean getCustom() {
        return isCustom;
    }

    public void setCustom(Boolean custom) {
        isCustom = custom;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

