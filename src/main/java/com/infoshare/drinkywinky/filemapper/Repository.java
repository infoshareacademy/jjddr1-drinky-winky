package com.infoshare.drinkywinky.filemapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Repository {
    private static final String PATH_NAME = "search.json";
    private DrinkList drinkList;
    private static final String MESSAGE = "File is saved";

    public Repository() {
    }

    public Drink getDrinkByName(String drinkName) {
        return drinkList.getDrinkByName(drinkName);
    }

    public Drink getGetDrinkById(String drinkId) {
        return drinkList.getDrinkById(drinkId);
    }

    public List<Drink> getListOfDrinksByIngredient(String ingredient) {
        return drinkList.getDrinksByIngredients(ingredient);
    }
    public List<Drink> getListOfCategories(String category) {
        return drinkList.getDrinksByCategory(category);
    }

    public DrinkList getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(DrinkList drinkList) {
        this.drinkList = drinkList;
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
        saveToNewFile();
        Repository repo = new Repository();
        DrinkList drinkList = readFile("DrinksList.json");
        List<Drink> salt = drinkList.getDrinksByIngredients("Salt");
        for (Drink drink : salt) {
            System.out.println(drink.getName());
        }
    }
}
