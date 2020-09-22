package com.infoshare.drinkywinky.display;


import com.infoshare.drinkywinky.repositories.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DrinkMenu {
    private static DrinkDisplay[] menuList;
    private List<DrinkDisplay> listOfDrinks = Arrays.asList(drinkMenu());

    public DrinkMenu(List<DrinkDisplay> listOfDrinks) {
        this.listOfDrinks = listOfDrinks;
    }

    public void setListOfDrinks(List<DrinkDisplay> listOfDrinks) {
        this.listOfDrinks = listOfDrinks;
    }

    public List<DrinkDisplay> getListOfDrinks() {
        return listOfDrinks;
    }

    ////////////////////////////////////////////////////
    public DrinkMenu(DrinkDisplay[] menuList) {
        this.menuList = menuList;
    }

    public DrinkMenu() {
    }

    public DrinkDisplay[] getMenuList() {
        return menuList;
    }

    public void setMenuList(DrinkDisplay[] menuList) {
        this.menuList = menuList;
    }

    //metoda wypelniania menu na pozycje drinka i na jego nazwe
    public static DrinkDisplay[] drinkMenu() {

        int position = 1;

        //pobranie listy nazw drinkow
        List drinkList = Repository.getInstance().getListOfDrinkNames();

        //stworzenie nowej tablicy ponumerowanych drinkow
        DrinkDisplay[] drinkDisplay = new DrinkDisplay[drinkList.size()];


        //petla wypelniajaca liste ponumerowanych drinkow
        for (int i = 0; i < drinkList.size(); i++) {
            drinkDisplay[i] = new DrinkDisplay();
            drinkDisplay[i].setMenuPosition(position++);
            drinkDisplay[i].setMenuDrink((String) drinkList.get(i));
        }
        menuList = drinkDisplay;
        return drinkDisplay;
    }

    public void displayDrinksMenu() {
        System.out.println(listOfDrinks);
        for (int i = 0; i < drinkMenu().length; i++) {
            System.out.println(drinkMenu()[i]);
        }

    }

    public void checkMenu() {
        for (int i = 0; i < drinkMenu().length; i++) {
            System.out.println(drinkMenu()[i]);
        }
        Scanner SCANNER = new Scanner(System.in);
        int choice = SCANNER.nextInt();

    }


}


   /* public List<String> getNamesOfDrinks() {
        List<Drink> drinkList = getAllDrink();
        List<String> drinkNames = drinkList
                .stream()
                .map(drink -> drink.getName())
                .collect(Collectors.toList());
        return drinkNames;
    }*/