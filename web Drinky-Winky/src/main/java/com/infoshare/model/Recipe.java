package com.infoshare.model;

import javax.persistence.*;

@Entity
@Table
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", unique = true, length = 100)
    private String recipeName;
    @Column (name = "drink_type")
    private String isAlcoholic;
    @Column(name ="modificaton_date")
    private String dateModified;
    @Column(name="type_of_glass")
    private String glass;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsAlcoholic() {
        return isAlcoholic;
    }

    public void setIsAlcoholic(String isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }
}
