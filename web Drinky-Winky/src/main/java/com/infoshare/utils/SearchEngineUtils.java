package com.infoshare.utils;

import com.infoshare.dto.DrinkDTO;

import com.infoshare.service.DrinkService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class SearchEngineUtils {

    @Inject
    DrinkService drinkService;


    public List<DrinkDTO> findDrinkByName(String input) {

        if (input != null || !input.isEmpty() || !input.isBlank()) {
            List<DrinkDTO> found = new ArrayList<>();
            List<DrinkDTO> drinkList = drinkService.getDrinkList();
            for (DrinkDTO foundDrink : drinkList) {

                //Name check
                if (foundDrink.getName().toLowerCase().contains(input.toLowerCase())) {
                    found.add(foundDrink);
                }
                //glass type check
                if (foundDrink.getGlassType().toLowerCase().contains(input.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
                //drink type check, if user want to find alcoholic or non alcoholic
                if (foundDrink.getDrinkType().toLowerCase().contains(input.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
                // category check
                if (foundDrink.getCategory().toString().toLowerCase().contains(input.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
                // trying to find an ingredient
                if (foundDrink.getIngredientList().stream().anyMatch(d -> d.getName().toLowerCase().contains(input.toLowerCase()))) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
            }
            return found;
        }
        return null;
    }

    public List<DrinkDTO> findDrinkByFilters(String category, String glass, String type) {
        List<DrinkDTO> found = new ArrayList<>();
        List<DrinkDTO> drinkList = drinkService.getDrinkList();
        for (DrinkDTO foundDrink : drinkList) {

            if (category != null || !category.isEmpty() || !category.isBlank()) {
                if (foundDrink.getCategory().toString().toLowerCase().contains(category.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
            }
            if (glass !=null || !glass.isEmpty() || !glass.isBlank()) {
                if (foundDrink.getGlassType().toLowerCase().contains(glass.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
            }
            if (type != null || !type.isEmpty() || !type.isBlank()){
                if (foundDrink.getDrinkType().toLowerCase().contains(type.toLowerCase())){
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
            }
            return found;
        }
        return null;
    }
}