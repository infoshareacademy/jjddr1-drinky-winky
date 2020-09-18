package DRINK.FileMapper;

import DRINK.Classes.Drink;
import DRINK.Classes.DrinkList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Repository {

    private static final String PATH_NAME = "search.json";
    private DrinkList drinkList;
    private static final String MESSAGE = "file is saved";

    public Drink getDrinkByName(String drinkName) {
        return drinkList.getDrinkByName(drinkName);
    }

    public Drink getGetDrinkId(String drinkId) {
        return drinkList.getDrinkById(drinkId);
    }

    public DrinkList getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(DrinkList drinkList) {
        this.drinkList = drinkList;
    }

    public List<Drink> getListOfDrinksByIngredient(String ingredient) {
        return drinkList.getDrinkByIngredient(ingredient);
    }

    static String saveToNewFile() {
        DrinkList drinkList = Repository.readFile(PATH_NAME);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("DrinksList.json"), drinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MESSAGE;
    }

    static DrinkList readFile(String path) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        DrinkList drinkList = null;
        try {
            drinkList = mapper.readValue(file, DrinkList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drinkList;
    }

    public static void main(String[] args) {

        Repository repo = new Repository();
        DrinkList drinkList = readFile("DrinksList.json");
        List<Drink> salt = drinkList.getDrinkByIngredient("Salt");
        for (Drink drink : salt) {
            System.out.println(drink.getStrDrink());
        }
    }
}



