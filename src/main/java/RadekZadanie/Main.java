package RadekZadanie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        File file = new File("/home/radoslaw/Desktop/jjddr1-drinky-winky/src/main/java/resources/search.json");
        Scanner myReader = new Scanner(file);
        while(myReader.hasNextLine()){
        String data = myReader.nextLine();
        DrinksJason wydruk = mapper.readValue(data, DrinksJason.class);
        System.out.println(wydruk);}


//        JsonSave jsonSave = new JsonSave();
//        System.out.println(jsonSave.saveJsonAsArray().toString());
    }
}
