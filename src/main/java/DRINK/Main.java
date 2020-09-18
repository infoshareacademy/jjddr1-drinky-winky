package DRINK;

import java.io.File;
import java.io.IOException;


import DRINK.Classes.DrinkList;
import DRINK.Menu.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("test.json");

        DrinkList drinkList = mapper.readValue(file, DrinkList.class);



     // System.out.println(drinkList.getDrinkById("11007").getStrCategory());
     //  System.out.println(drinkList.toString());
     //   System.out.println("trutut" + drinkList.getCategoryByName("Ordinary Drink"));

    }
}
