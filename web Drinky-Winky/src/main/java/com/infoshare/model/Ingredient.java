package com.infoshare.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
@NamedQuery(
        name = "Ingredient.findIngredientByName",
        query = "SELECT distinct i.name FROM Ingredient i WHERE i.name in :names"),
@NamedQuery(
        name = "Ingredient.getIngredientList",
        query = "SELECT distinct i.name FROM Ingredient i")
})

@Entity
@Table(name = "ingredient", indexes = {@Index(name = "idx_name",columnList = "name")})
public class Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", length = 100)
    @NotNull
    private String name;

    @Column(name = "measure")
    @NotNull
    private String measure;

    @ManyToMany(mappedBy = "ingredientList")
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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
}
