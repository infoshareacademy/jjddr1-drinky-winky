package zadanie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
//        DrinksJason wydruk = new DrinksJason();
//        File file = new File("/home/radoslaw/Desktop/jjddr1-drinky-winky/src/main/java/resources/search.json");
//        Scanner myReader = new Scanner(file);
//        while(myReader.hasNextLine()){
//        String data = myReader.nextLine();
//        wydruk = mapper.readValue(data, DrinksJason.class);
//        System.out.println(wydruk);}
Mapper mapper = new Mapper();
        List<DrinkList> drinkLists = mapper.saveJsonAsArray();
        System.out.println(drinkLists);
//        JsonSave jsonSave = new JsonSave();
//        System.out.println(jsonSave.saveJsonAsArray().toString());
    }
}
