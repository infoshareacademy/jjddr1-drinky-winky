package DRINK;

import DRINK.Classes.DrinkList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileList {
    public static void main(String[] args) throws FileNotFoundException {
        DrinkList drinkList = DRINK.JsonMapper.drinkList();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("test.json"), drinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
