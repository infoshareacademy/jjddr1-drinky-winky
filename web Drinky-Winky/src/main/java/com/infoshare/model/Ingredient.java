package com.infoshare.model;

import javax.persistence.*;


@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 100)
    private String ingredientName;

    @Column(name = "measure")
    private String measurement;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id", referencedColumnName = "id")
    private Drink drink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
