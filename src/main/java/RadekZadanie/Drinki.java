package RadekZadanie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drinki {
    private String idDrink;
    private String strDrink;


    public Drinki(@JsonProperty ("idDrink")String idDrink,
                  @JsonProperty("strDrink")String strDrink) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }
//
//    public List<Drinki> getStrIngredient() {
//        return strIngredient;
//    }

//    public void setIdDrink(@JsonProperty("idDrink") String idDrink) {
//        this.idDrink = idDrink;
//    }

//    public void setStrDrink(@JsonProperty("strDrink") String strDrink) {
//        this.strDrink = strDrink;
//    }
//
//    public void setStrIngredient(@JsonProperty("strIngredient1") List<Drinki> strIngredient) {
//        this.strIngredient = strIngredient;
//    }


    @Override
    public String toString() {
        return "Drinki{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                '}';
    }
}




