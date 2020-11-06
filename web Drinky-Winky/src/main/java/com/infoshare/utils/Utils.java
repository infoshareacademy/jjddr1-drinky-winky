package com.infoshare.utils;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.service.DrinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class Utils {
    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    DrinkService drinkService;

    public List<DrinkDTO> getRequestDrinkList(int request, int size) {

//        int fromIndex = (request - 1) * size;
//        int toIndex = request * size - 1;

        int fromIndex = request - 1;
        int toIndex = request + size - 1;

        int drinkDbSize = drinkService.getDrinkList().size();

        if (fromIndex >= 0 && toIndex <= drinkDbSize-1) {
            return drinkService.getDrinkList().subList(fromIndex, toIndex);
        } else {
            logger.info("Database counts {} drinks. Give correct bound numbers", drinkDbSize);
            return drinkService.getDrinkList().subList(1,1);
        }
    }
}
