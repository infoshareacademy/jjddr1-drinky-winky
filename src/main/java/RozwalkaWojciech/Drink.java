package RozwalkaWojciech;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {
    private final String idDrink;
    private final String strDrink;

    public Drink(@JsonProperty("idDrink") String idDrink,
                 @JsonProperty("strDrink") String strDrink
    ) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;

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
