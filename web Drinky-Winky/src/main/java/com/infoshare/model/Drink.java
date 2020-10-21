package com.infoshare.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Drink implements Comparable<Drink> {
    @Id
    @GeneratedValue
    private final String id;
    @Column
    private final String name;
    @Column
    private final String category;
    @Column
    private final String recipe;
    @Column
    private final String alcoholic;
    @Column
    private final String dateModified;
    @Column
    private final String glass;


    private List<String> ingredients = new ArrayList<>();
    private List<String> measures = new ArrayList<>();


//    public void setFakeMeasure(String measure) {
//        if (measure != null) {
//            measures.add(measure);
//        }
//    }

    public Drink(String id,
                 String name,
                 String category,
                 String recipe,
                 String alcoholic,
                 String dateModified,
                 String glass) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.alcoholic = alcoholic;
        this.dateModified = dateModified;
        this.glass = glass;
    }

    public Drink(String id,
                 String name,
                 String category,
                 String recipe,
                 String alcoholic,
                 String dateModified,
                 String glass,
                 List<String> ingredients,
                 List<String> measures ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.alcoholic = alcoholic;
        this.dateModified = dateModified;
        this.glass = glass;
        this.measures = measures;
    }

    public String getId() {
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getMeasures() {
        return measures;
    }

    @Override
    public String toString() {
        return "\n\u001b[33mDrink name: \u001b[0m" + name + "\n\u001b[33mCategory: \u001b[0m" + category + "\n\u001b[33mIngredients with measures: \u001b[0m" +
                ingredients +
                "\n\u001b[33mID: \u001b[0m" + id + "\n\u001b[33mRecipe: \n\u001b[0m" + recipe + "\n\u001b[33mAlcoholic: \u001b[0m" +
                alcoholic + "\n\u001b[33mGlass type: \u001b[0m" + glass + "\n\u001b[33mDate of modification: \u001b[0m" + dateModified + "\n";
    }

    @Override
    public int compareTo(Drink o) {
        return name.compareToIgnoreCase(o.getName());
    }
}
