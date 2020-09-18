package DRINK.Classes;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchByCategory {
    private final String strCategory;
    private List<String> category = new ArrayList<>();


    public String getStrCategory() {
        return strCategory;
    }

    @JsonSetter()
    public String setStrCategory(String category1) {
        if (category != null) {
            category.add(category1);
        }
        return category1;
    }

    public SearchByCategory(
            @JsonAlias("strCategory")
            @JsonProperty("strCategory") String strCategory
    ) {

        this.strCategory = strCategory;
    }

    @Override
    public String toString() {
        return "SearchByCategory : " + strCategory + "\n";
    }
}