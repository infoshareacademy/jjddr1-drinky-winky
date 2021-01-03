package com.infoshare.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = Category.FIND_CATEGORY_BY_NAME,
                query = "SELECT distinct c FROM Category c WHERE c.name like :name"),

        @NamedQuery(
                name = Category.FIND_CATEGORY_BY_ID,
                query = "SELECT c FROM Category c WHERE c.id in :ids"),
        @NamedQuery(
                name = Category.GET_CATEGORY_LIST,
                query = "SELECT DISTINCT c FROM Category c"),
        @NamedQuery(
                name = Category.GET_CATEGORY_IDS,
                query = " SELECT c.id FROM Category c"),
        @NamedQuery(
                name = Category.FIND_DRINKS_BY_CATEGORY_NAME,
                query = " SELECT distinct m.name FROM Category u, Drink m JOIN u.drinkList r WHERE r.id=u.id")
})

@Entity
@Data
public class Category {

    public static final String FIND_CATEGORY_BY_NAME = "Category.findCategoryByName";
    public static final String FIND_CATEGORY_BY_ID = "Category.findCategoryById";
    public static final String GET_CATEGORY_LIST = "Category.getCategoryList";
    public static final String GET_CATEGORY_IDS = "Category.getCategoryIds";
    public static final String FIND_DRINKS_BY_CATEGORY_NAME = "Category.getDrinksListByCategoryName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Drink> drinkList = new ArrayList<>();
}
