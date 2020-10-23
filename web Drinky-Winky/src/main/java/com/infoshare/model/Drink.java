package com.infoshare.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Drink {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private String recipe;
    @Column
    private String alcoholic;
    @Column
    private String dateModified;
    @Column
    private String glass;

    @OneToMany(mappedBy = "drink", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;



    public Drink() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getGlass() {
        return glass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }
}

