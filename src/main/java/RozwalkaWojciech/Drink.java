package RozwalkaWojciech;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Drink {
    private final String idDrink;
    private final String strDrink;
    private final String[] ingredient;


    public Drink(@JsonProperty("idDrink") String idDrink, @JsonProperty("strDrink") String strDrink, String[] ingredient) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", ingredient=" + Arrays.toString(ingredient) +
                '}';
    }
}
