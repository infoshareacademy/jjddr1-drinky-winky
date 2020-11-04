package com.infoshare.service;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestScoped
public class  StartingPageService {
    @Inject
    DrinkService drinkService;

    public List<Drink> getDrinksPerPage(int pageNumber, List<Drink> filterList) {
        int pageSize = 7;

        if (pageSize <= 0 || pageNumber <= 0) {
            throw new IllegalArgumentException("Invalid page size : " + pageSize);
        }
        int fromIndex = (pageNumber - 1) * pageSize;
        if (filterList == null || filterList.size() < fromIndex) {
            return Collections.emptyList();
        }
        return filterList.subList(fromIndex, Math.min(fromIndex + pageSize, filterList.size()));
    }

    public Integer getLastNumberPage(List<Drink> drinkList) {
        int pageSize = 7;
        return (drinkList.size() + pageSize - 1) / pageSize;
    }

    public List<DrinkDTO> getDrinkByFilterOption(String filterOption) {
        List<DrinkDTO> result = new ArrayList<>();
        String allDrinks = "All Drinks";
        if (filterOption == allDrinks) {
            result = drinkService.getDrinkList();
        }
        return result;
    }
}
