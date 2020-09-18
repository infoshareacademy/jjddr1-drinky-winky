package DRINK.Classes;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Drink {
    private final String idDrink;
    private final String strDrink;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private final String strCategory;
    private List<String> ingredients = new ArrayList<>();
    private SearchByCategory searchByCategory;

    @JsonProperty("fake")
    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6"})
    private String fakeIngredient;

    public String getFakeIngredient() {
        return fakeIngredient;
    }

    @JsonSetter()
    public void setFakeIngredient(String ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }


    public Drink(@JsonProperty("idDrink") String idDrink,
                 @JsonProperty("strDrink") String strDrink,
                 @JsonProperty("strCategory") String strCategory

    ) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.fakeIngredient = fakeIngredient;
        this.strCategory = strCategory;

    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }
    public String getStrCategory() {
        return strCategory;
    }

    @Override
    public String toString() {
        return "Drink name : " + strDrink +
                ", SearchByCategory : " + strCategory + ",\nIngredients : \n" + ingredients +
                " ,"+ " idDrink : " + idDrink+".\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink)) return false;
        Drink drink = (Drink) o;
        return Objects.equals(getIdDrink(), drink.getIdDrink()) &&
                Objects.equals(getStrDrink(), drink.getStrDrink()) &&
                Objects.equals(getStrCategory(), drink.getStrCategory()) &&
                Objects.equals(getIngredients(), drink.getIngredients()) &&
                Objects.equals(getFakeIngredient(), drink.getFakeIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDrink(), getStrDrink(), getStrCategory(), getIngredients(), getFakeIngredient());
    }
}
