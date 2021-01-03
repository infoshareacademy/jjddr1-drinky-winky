package com.infoshare.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = Ingredient.FIND_INGREDIENT_BY_NAME,
                query = "SELECT distinct i.name FROM Ingredient i WHERE i.name in :names"),
        @NamedQuery(
                name = Ingredient.GET_INGREDIENT_LIST,
                query = "SELECT distinct i FROM Ingredient i")
})

@Entity
@Table(indexes = {@Index(name = "idx_name", columnList = "name")})
@Data
public class Ingredient {

    public static final String FIND_INGREDIENT_BY_NAME = "Ingredient.findIngredientByName";
    public static final String GET_INGREDIENT_LIST = "Ingredient.getIngredientList";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 100)
    @NotNull
    private String name;

    @NotNull
    private String measure;

    @ManyToMany(mappedBy = "ingredientList")
    private List<Drink> drinkList = new ArrayList<>();
}
