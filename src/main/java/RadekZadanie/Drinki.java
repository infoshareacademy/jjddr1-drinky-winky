package RadekZadanie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Drinki {
    private String idDrink;
    private String strDrink;
    private List<String> strIngredient;

    public Drinki(@JsonProperty("idDrink") String idDrink,
                  @JsonProperty("strDrink") String strDrink,
                  @JsonProperty("strIngredient1") List<String> strIngredient) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strIngredient = strIngredient;
    }

    @Override
    public String toString() {
        return "Drinki{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", strIngredient=" + strIngredient +
                '}';
    }
}
