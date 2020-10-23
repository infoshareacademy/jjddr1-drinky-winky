package com.infoshare.model;

import javax.persistence.*;


@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue
    private String id;
    @Column
    private String ingredientName;
    @Column
    private String measurement;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id",referencedColumnName = "id")
    private Drink drink;

    public Ingredient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measuerement) {
        this.measurement = measuerement;
    }
}
