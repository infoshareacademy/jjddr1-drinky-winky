package com.infoshare.service;

import com.infoshare.dao.DrinkDAO;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class DrinkService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    DrinkDAO drinkDAO;

    public void saveDrink(DrinkDTO drinkDTO) {
        drinkDAO.saveDrink(drinkDTO);
        logger.info("Drink has been saved");
    }

    public Drink updateDrink(Long id, DrinkDTO drinkDTO) {
        logger.info("Drink update");
        return drinkDAO.edit(id, drinkDTO);
    }

    public Drink findDrinkById(Long id) {
        logger.info("Get drink by id");
        return drinkDAO.findById(id);
    }

    public void removeDrinkById(Long id) {
        drinkDAO.remove(id);
        logger.info("Drink has been removed");
    }

    public List<Drink> getDrinkList() {
        return drinkDAO.getDrinkList();
    }
}
