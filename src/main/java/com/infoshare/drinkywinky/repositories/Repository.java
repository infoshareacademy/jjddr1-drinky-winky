package com.infoshare.drinkywinky.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Repository {
    private static final String DATA_BASE_PATH_NAME = "search.json";
    private static final String USER_DATA_BASE_PATH_NAME = "drink list.json";
    private static final String MESSAGE = "File is saved";
    private static Repository INSTANCE = null;
    private DrinkList drinkList;

    public Repository() {
        drinkList = readFile(USER_DATA_BASE_PATH_NAME);
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public Drink getDrinkByName(String drinkName) {
        return drinkList.getDrinkByName(drinkName);
    }

    public Drink getDrinkById(String drinkId) {
        return drinkList.getDrinkById(drinkId);
    }

    public List<Drink> getListOfDrinkByIngredient(String ingredient) {
        return drinkList.getDrinkByIngredients(ingredient);
    }

    public List<Drink> getListOfCategories(String category) {
        return drinkList.getDrinkByCategory(category);
    }

//    public List<Drink> getFavoriteDrink() {
//        return drinkList.getFavoriteDrink();
//    }

    public DrinkList getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(DrinkList drinkList) {
        this.drinkList = drinkList;
    }

    static String saveToNewFile() {
        DrinkList drinkList = Repository.readFile(DATA_BASE_PATH_NAME);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(USER_DATA_BASE_PATH_NAME), drinkList);
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

    /**
     * TEST METHOD ONLY
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * METHOD MUST RUN ONLY ONCE!
         * WHEN USER OPEN APP FIRST TIME, OR FOR HIS REQUEST!
         * Option should be selected from the MENU!
         */
        saveToNewFile();

        /**
         * SINGLETON to use for Repository getters
         *
         * Repository.getInstance().getSOMETHING
         */
        List<Drink> salt = Repository.getInstance().getListOfDrinkByIngredient("Salt");

        /**
         * Way to print drink names after the ingredient ("Salt") searched
         */
        for (Drink drink : salt) {
            System.out.println(drink.getName());
        }

        System.out.println(Repository.getInstance().getDrinkList());
    }
}
