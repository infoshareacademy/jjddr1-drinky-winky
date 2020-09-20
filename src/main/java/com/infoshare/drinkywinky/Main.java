package com.infoshare.drinkywinky;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.repositories.Repository;

public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("search.json");

        try {
            DrinkList drinkList = mapper.readValue(file, DrinkList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu.mainMenu();

        System.out.println(Repository.getInstance().getDrinkList());


    }
 }
