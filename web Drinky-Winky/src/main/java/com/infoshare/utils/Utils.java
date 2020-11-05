package com.infoshare.utils;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.service.DrinkService;

import javax.inject.Inject;
import java.util.List;


public class Utils {

    @Inject
    DrinkService drinkService;

    public List<DrinkDTO> getRequestDrinkList(int request, int size) {

        int fromIndex = (request - 1) * size;
        int toIndex = request * size - 1;

        return drinkService.getDrinkList().subList(fromIndex, toIndex);
    }

}
