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

        List<> list = new ArrayList();
        list = mapper.readValue("search.json", DrinkList<>.class);

        DrinkList[] drinkLists = mapper.readValue("search.json", DrinkList[].class);
        System.out.println(Arrays.toString(drinkLists));

        System.out.println(drinkLists);












/*
        //private static final JsonProvider jsonProvider = new JsonProvider();
        ObjectMapper mapper = new ObjectMapper();

        java.io.File file = new java.io.File("search.json");

        String jsonString = mapper.writeValueAsString(file);
        System.out.println(jsonString);





        java.io.File file1 = new java.io.File("search.json");
        List<String> allDataList = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            allDataList = Collections.singletonList(sc.nextLine());
        }
        System.out.println(allDataList);
*/


    }
}
