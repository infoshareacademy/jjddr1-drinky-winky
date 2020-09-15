package RozwalkaWojciech;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    private List<String> ingredients = new ArrayList<>();
    private String fakeIngredient;


    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3"})
    public String getFakeIngredient() {
        return fakeIngredient;
    }

    @JsonSetter()
    public void setFakeIngredient(String ingredient) {
        ingredients.add(ingredient);
    }


}
