package com.infoshare.utils;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.service.DrinkService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class Utils {

    @Inject
    DrinkService drinkService;

    public List<DrinkDTO> getRequestDrinkList(int request, int size) {

        int fromIndex = (request - 1) * size;
        int toIndex = request * size;

        if (toIndex > drinkService.getDrinkList().size()) {
            toIndex = drinkService.getDrinkList().size();
        }

        return drinkService.getDrinkList().subList(fromIndex, toIndex);
    }

}
