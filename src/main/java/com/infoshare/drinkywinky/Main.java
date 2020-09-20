package com.infoshare.drinkywinky;

import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.repositories.Repository;

public class Main {

    public static void main(String[] args) {

        Menu.mainMenu();

        System.out.println(Repository.getInstance().getDrinkList());


    }
 }
