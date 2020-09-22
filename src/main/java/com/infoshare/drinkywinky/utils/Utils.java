package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public Utils() {
    }

    /**
     * @return only names of all drink
     */
    public static List<String> getNamesOfDrink() {
        return Repository.getInstance().getDrinkList().getAllDrink()
                .stream()
                .map(Drink::getName)
                .collect(Collectors.toList());
    }


}
