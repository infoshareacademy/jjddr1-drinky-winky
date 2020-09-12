package RadekZadanie;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DrinksJason {
    List<Drinki> drinks;

    public DrinksJason(@JsonProperty("drinks")List<Drinki> drinks) {
        this.drinks = new ArrayList<>(drinks);
    }

    public List<Drinki> getDrinks() {
        return drinks;
    }
}
