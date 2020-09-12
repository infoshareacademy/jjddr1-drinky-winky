package RadekZadanie;

import java.util.List;

public class DrinkList {
    private String idDrink;
    private String strDrink;
    private List<String> strIngredient;


    public String getName() {
        return strDrink;
    }

    public List<String> getStrIngredient() {
        return strIngredient;
    }

    public String getIdDrink() {
        return idDrink;
    }

    @Override
    public String toString() {
        return "DrinkList{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", strIngredient=" + strIngredient +
                '}';
    }
}