package zadanie;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {
    private final String idDrink;
    private final String strDrink;
    private List<String> ingredients = new ArrayList<>();
    @JsonProperty("fake")
    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6"})
    private String fakeIngredient;

    public String getFakeIngredient() {
        return fakeIngredient;
    }

    @JsonSetter("fake")
    public void setFakeIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public Drink(@JsonProperty("idDrink") String idDrink,
                 @JsonProperty("strDrink") String strDrink,
                 @JsonProperty("fake") String fakeIngredient

    ) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.fakeIngredient = fakeIngredient;

    }

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                '}';
    }
}


