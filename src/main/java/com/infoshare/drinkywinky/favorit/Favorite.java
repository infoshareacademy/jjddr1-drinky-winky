package com.infoshare.drinkywinky.favorit;

import com.infoshare.drinkywinky.model.Drink;

import java.util.List;

public class Favorite {
    private List<Drink> favoriteDrinkList;

    public List<Drink> getFavoriteDrinkList() {
        return favoriteDrinkList;
    }

    public String addFavorite(Drink drink) {


        favoriteDrinkList.add(drink);
        return "Drink has been saved!";
    }
}
