package RadekZadanie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final ObjectMapper mapper = new ObjectMapper();
    DrinkList driny = new DrinkList();

    public static void main(String[] args) throws IOException {
        File file = new File("search.json");
        Scanner myReader = new Scanner(file);
        while(myReader.hasNextLine());
        String data = myReader.nextLine();

       Drinki drinek = mapper.readValue(file,Drinki.class);
        System.out.println(drinek);

    }
}
