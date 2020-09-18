package DRINK;

import DRINK.Classes.DrinkList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class JsonMapper {

    static DrinkList drinkList() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("test.json");
        DrinkList drinkList = null;
        try {
            drinkList = mapper.readValue(file, DrinkList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drinkList;
    }

    private static void saveToNewFile() {
        DrinkList drinkList = JsonMapper.drinkList();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("DrinksList.json"), drinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}