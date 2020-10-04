package com.infoshare.drinkywinky.searchby;

import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;

public class ShowByNames {
    public static void main(String[] args) {
        SubmenuCreator showByNames = new SubmenuCreator(Utils.getNamesOfAllDrink(Repository.getInstance().getDrinkList()));
    }
}
