package com.infoshare.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(value = {
        @NamedQuery(
                name = Drink.GET_DRINK_LIST,
                query = "SELECT r FROM Drink r"),
        @NamedQuery(
                name = Drink.GET_RECIPE_BY_CATEGORY,
                query = "SELECT r FROM Drink r where r.category IN :categories order by r.name ASC "
        ),
        @NamedQuery(
                name = Drink.GET_DRINK_BY_CATEGORY_AND_INGREDIENT,
                query = "SELECT r FROM Drink r JOIN r.ingredientList i WHERE r.category IN :categories AND ( i.name IN :ingredients) GROUP BY r HAVING COUNT(distinct i.name)=:namesLenght order by r.name ASC "),
        @NamedQuery(
                name = Drink.GET_DRINK_BY_NAME,
                query = "SELECT r FROM Drink r WHERE r.name = :name "
        )
})

@Entity
@Data
public class Drink {
    public static final String GET_RECIPE_BY_CATEGORY = "Drink.findDrinkByCategory";
    public static final String GET_DRINK_BY_CATEGORY_AND_INGREDIENT = "Drink.findDrinkByCategoryIdAndIngredientName";
    public static final String GET_DRINK_BY_NAME = "Drink.getDrinkByName";
    public static final String GET_DRINK_LIST = "Drink.getDrinkList";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, length = 100)
    @NotNull
    private String name;

    @NotNull
    private Boolean isCustom;

    @NotNull
    private Boolean isApproved;

    @Column(length = 5000)
    @NotNull
    private String recipe;

    @NotNull
    private String drinkType;

    @NotNull
    private String glassType;

    @NotNull
    private String modificationDate;

    @Column(length = 1024)
    @NotNull
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "category_id")
    private Category category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "drink_to_ingredient",
            joinColumns = {@JoinColumn(name = "drink_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")}
    )
    private List<Ingredient> ingredientList = new ArrayList<>();

    @ManyToMany(mappedBy = "favouriteDrinkList")
    private List<User> users = new ArrayList<>();

    public Drink() {
    }

    public Drink(@NotNull String name, @NotNull Boolean isCustom, @NotNull Boolean isApproved, @NotNull String recipe,
                 @NotNull String drinkType, @NotNull String glassType, @NotNull String modificationDate,
                 @NotNull String imageUrl, Category category, List<Ingredient> ingredientList, List<User> users) {
        this.name = name;
        this.isCustom = isCustom;
        this.isApproved = isApproved;
        this.recipe = recipe;
        this.drinkType = drinkType;
        this.glassType = glassType;
        this.modificationDate = modificationDate;
        this.imageUrl = imageUrl;
        this.category = category;
        this.ingredientList = ingredientList;
        this.users = users;
    }

    public Drink(@NotNull String name, @NotNull String recipe, @NotNull String drinkType, @NotNull String glassType) {
        this.name = name;
        this.recipe = recipe;
        this.drinkType = drinkType;
        this.glassType = glassType;

    }
}
