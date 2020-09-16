package zadanie;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrinkList {
    private String idDrink;
    private String strDrink;


    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }
//    public List<Drinki> getStrIngredient() {
//        return strIngredient;
//    }


    @Override
    public String toString() {
        return "Drinki{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                '}';
    }
}




