package com.infoshare.service;

import com.infoshare.dao.DrinkDAO;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DrinkService {

    @Inject
    DrinkDAO drinkDAO;

    public DrinkDTO saveDrink(DrinkDTO drinkDTO) {
        return drinkDAO.saveDrink(drinkDTO);
    }

    public Drink findById(Long id) {
        return drinkDAO.findById(id);
    }

    public Drink updateDrink(Long id, DrinkDTO drinkDTO) {
        return drinkDAO.edit(id, drinkDTO);
    }

    public boolean remove(Long id) {
        return drinkDAO.remove(id);
    }
}
