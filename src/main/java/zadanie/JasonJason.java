package zadanie;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JasonJason {
    public static void main(String[] args) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("/home/radoslaw/Desktop/jjddr1-drinky-winky/src/main/java/resources/search.json");
        Object obj = jsonParser.parse(reader);
        JSONObject drinksJSONObject = (JSONObject) obj;
        JSONArray array = (JSONArray) drinksJSONObject.get("drinks");

        for (int i = 0; i < array.size(); i++) {
            JSONObject drink = (JSONObject) array.get(i);

            String idDrink = (String) drink.get("");
            System.out.println(idDrink);
        }
    }
}
