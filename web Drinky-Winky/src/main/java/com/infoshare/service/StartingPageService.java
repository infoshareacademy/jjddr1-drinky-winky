package com.infoshare.service;

import com.infoshare.model.Drink;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestScoped
public class StartingPageService {
    @Inject
    DrinkService drinkService;

    public List<Drink> getDrinksPerPage(int pageNumber) {

        List<Drink> result = new ArrayList<>();
        List<Drink> drinkList = drinkService.getRecipesList();
        int pageSize = 7;

        if (pageSize <= 0 || pageNumber <= 0) {
            throw new IllegalArgumentException("Invalid page size : " + pageSize);
        }
        int fromIndex = (pageNumber - 1) * pageSize;
        if (drinkList == null || drinkList.size() < fromIndex) {
            return Collections.emptyList();
        }
        return drinkList.subList(fromIndex, Math.min(fromIndex + pageSize, drinkList.size()));
    }

    public Integer getLastNumberPage(List<Drink> drinkList) {
        int pageSize = 7;
        return (drinkList.size() + pageSize - 1) / pageSize;
    }

    public List<Drink> getDrinkByFilterOption(String filterOption) {
        List<Drink> result = new ArrayList<>();
        String allDrinks = "All Drinks";
        if (filterOption == allDrinks) {
            result = drinkService.getRecipesList();
        }
        return result;
    }
}
