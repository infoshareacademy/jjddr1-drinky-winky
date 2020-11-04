package com.infoshare.model;


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
                query = " SELECT c.id FROM Category c"
        )
})

@Entity
@Table(name = "category")
public class Category {

    public static final String FIND_CATEGORY_BY_NAME = "Category.findCategoryByName";
    public static final String FIND_CATEGORY_BY_ID = "Category.findCategoryById";
    public static final String GET_CATEGORY_LIST = "Category.getCategoryList";
    public static final String GET_CATEGORY_IDS = "Category.getCategoryIds";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Drink> drinkList = new ArrayList<>();

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
