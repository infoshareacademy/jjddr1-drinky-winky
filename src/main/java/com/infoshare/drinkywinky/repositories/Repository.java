package com.infoshare.drinkywinky.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;

import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * Class with read/write function from Json file and getters?
 */
public class Repository {
    private static final String DATA_BASE_PATH_NAME = "search.json";
    private static final String USER_DATA_BASE_PATH_NAME = "drink list.json";
    private static final String MESSAGE = "File is saved";
    private static Repository INSTANCE = null;
    private static DrinkList drinkList;

    public Repository() {
        drinkList = readFile(USER_DATA_BASE_PATH_NAME);
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }
    /**
     * @param drinkId specific number of a drink entered by user
     * @return whole recipe under the specific id
     */
    public Drink getDrinkById(String drinkId) {
        return drinkList.getDrinkById(drinkId);
    }
    /**
     * @param drinkName name of a drink entered by user
     * @return whole recipe under the specific name
     */
    public Drink getDrinkByName(String drinkName) {
        return drinkList.getDrinkByName(drinkName);
    }
    /**
     * @param category category of drink entered by user
     * @return whole recipe under the specific category
     */
    public Drink getDrinkByCategories(String category) {
        return drinkList.getDrinkByCategory(category);
    }
    /**
     * @param ingredient one ingredient entered by user
     * @return whole recipes of drinks with the specific ingredient
     */
    public List<Drink> getListOfDrinkByIngredient(String ingredient) {
        return drinkList.getDrinkByIngredients(ingredient);
    }
    /**
     * @return whole list os drinks
     */
    public DrinkList getDrinkList() {
        return drinkList;
    }
    /**
     * Method to save Json database file into a new file
     * @return File is saved message
     */
    public static String saveToNewFile() {
        DrinkList drinkList = Repository.readFile(DATA_BASE_PATH_NAME);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(USER_DATA_BASE_PATH_NAME), drinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MESSAGE;
    }
    /**
     * Method to extract data from Json database file
     * @return ArrayList of drink's recipes
     */
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
}
