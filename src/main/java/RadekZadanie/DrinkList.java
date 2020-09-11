package RadekZadanie;

import java.util.List;

public class DrinkList {
    private final String idDrink;
    private final String strDrink;
    private final List<String> strIngredient;

    public DrinkList(String idDrink, String strDrink, List<String> strIngredient) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strIngredient = strIngredient;
    }

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