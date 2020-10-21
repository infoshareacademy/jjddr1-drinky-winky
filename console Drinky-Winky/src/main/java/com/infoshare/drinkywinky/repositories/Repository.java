package com.infoshare.drinkywinky.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.model.DrinkList;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Repository {
    private static final String DATA_BASE_PATH_NAME = "console Drinky-Winky/src/main/resources/search.json";
    private static final String USER_DATA_BASE_PATH_NAME = "console Drinky-Winky/src/main/resources/drink list.json";
    private static final String FAVORITE_DRINK_LIST_PATH_NAME = "console Drinky-Winky/src/main/resources/favorite drink list.json";
    private static final String MESSAGE = "File is saved";
    private static Repository INSTANCE;
    private final DrinkList drinkList;
    private final DrinkList favoriteDrinkList;

    public Repository() {
        drinkList = readFile(USER_DATA_BASE_PATH_NAME);
        favoriteDrinkList = readFile(FAVORITE_DRINK_LIST_PATH_NAME);
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public Drink getDrinkById(String drinkId) {
        return drinkList.getDrinkById(drinkId);
    }

    public List<Drink> getDrinkListByName(String drinkName) {
        return drinkList.getDrinkListByName(drinkName);
    }

    public List<Drink> getFavouriteDrinkListByName(String drinkName) {
        return favoriteDrinkList.getDrinkListByName(drinkName);
    }

    public Set<Drink> getDrinkByCategories(String category) {
        return drinkList.getDrinkByCategory(category);
    }

    public List<Drink> getListOfDrinkByIngredient(String ingredient) {
        return drinkList.getDrinkByIngredients(ingredient);
    }

    public DrinkList getDrinkList() {
        return drinkList;
    }

    public DrinkList getFavouriteDrinkList() {
        return favoriteDrinkList;
    }

    public Drink getDrinkByName(String name) {
        return drinkList.getDrinkByName(name);
    }

    public Drink getFavouriteDrinkByName(String name) {
        return favoriteDrinkList.getDrinkByName(name);
    }

    public static void sortList(DrinkList drinkList) {
        Collections.sort(drinkList.getAllDrink());
    }

    public void add(Drink drink) {
        drinkList.addDrink(drink);
        saveToFile(drinkList, USER_DATA_BASE_PATH_NAME);
    }

    public void remove(Drink drink) {
        drinkList.removeDrink(drink);
        saveToFile(drinkList, USER_DATA_BASE_PATH_NAME);
    }

    public void addFavorite(Drink drink) {
        favoriteDrinkList.addDrink(drink);
        saveToFile(favoriteDrinkList, FAVORITE_DRINK_LIST_PATH_NAME);
    }

    public void removeFavorite(Drink drink) {
        favoriteDrinkList.removeDrink(drink);
        saveToFile(favoriteDrinkList, FAVORITE_DRINK_LIST_PATH_NAME);
    }

    public static void saveToFile(DrinkList drinkList, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path), drinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String writeFavouriteDrink(DrinkList favoriteDrinkList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(FAVORITE_DRINK_LIST_PATH_NAME), favoriteDrinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MESSAGE;
    }

    public static void loadDataBase() {
        DrinkList drinkList = Repository.readFile(DATA_BASE_PATH_NAME);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(USER_DATA_BASE_PATH_NAME), drinkList);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
