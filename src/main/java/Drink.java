import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
class JasonProvider {
    private final int idDrink;
    private final String strDrink;
    private final String[] strIngredient;

    public JasonProvider
            (@JsonProperty("id") int idDrink,
             @JsonProperty("name") String strDrink,
             @JsonProperty("ingredient") String[] strIngredient) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strIngredient = strIngredient;
    }

    @Override
    public String toString() {
        return "JasonProvider{" +
                "idDrink=" + idDrink +
                ", strDrink='" + strDrink + '\'' +
                ", strIngredient=" + Arrays.toString(strIngredient) +
                '}';
    }




}
