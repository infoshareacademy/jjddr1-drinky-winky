package RozwalkaWojciech;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    private List<String> ingredients = new ArrayList<>();
    private String fakeIngredient;


    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5", "strIngredient6"})
    public String getFakeIngredient() {
        return fakeIngredient;
    }

    @JsonSetter("fakeIngredients")
    public void setFakeIngredient(String ingredient) {
        ingredients.add(ingredient);
    }


}
