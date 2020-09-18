package drink;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import drink.classes.DrinkList;
import drink.menu.Menu;


public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("test.json");

        try {
            DrinkList drinkList = mapper.readValue(file, DrinkList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu.mainMenu();
    }
 }
