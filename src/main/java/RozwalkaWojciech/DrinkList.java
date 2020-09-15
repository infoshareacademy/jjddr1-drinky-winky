package RozwalkaWojciech;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DrinkList {

    private final List<Drink> allDrink;

    public DrinkList(@JsonProperty("drinks") List<Drink> allDrink) {
        this.allDrink = new ArrayList<>();
    }



    @Override
    public String toString() {
        return "DrinkList{" +
                "allDrink=" + allDrink +
                '}';
    }
}
