package RozwalkaWojciech;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("search.json");

        DrinkList drinkList = mapper.readValue(file, DrinkList.class);

        System.out.println(drinkList.getDrinkById("11007").getStrDrink());
        System.out.println(drinkList.getDrinkByName("Margarita"));



        System.out.println(drinkList);

    }
}
