package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.menu.SubmenuCreator;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;

import java.util.ArrayList;

public class ShowSubmenu {

    public void showSubmenuByNames() {
        SubmenuCreator showByNames = new SubmenuCreator(Utils.getNamesOfAllDrink(Repository.getInstance().getDrinkList()));
    }

    public void showSubmenuByIngredients() {
        SubmenuCreator showByIngredients = new SubmenuCreator(new ArrayList<>(Utils.getNamesOfAllIngredients(Repository.getInstance().getDrinkList())));
    }

    public void showSubmenuByCategories() {
        SubmenuCreator showByCategories = new SubmenuCreator(new ArrayList<>(Utils.getCategoryOfAllDrink(Repository.getInstance().getDrinkList())));
    }
}
