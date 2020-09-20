package com.infoshare.drinkywinky;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.filemapper.Repository;


public class Main {

    public static void main(String[] args) {

        Repository repo = new Repository();
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
