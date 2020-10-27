package com.infoshare.service;

import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.DrinkDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DrinkService {

    @Inject
    DrinkDao drinkDao;

    public DrinkDto saveDrink(DrinkDto drinkDto) {
        return drinkDao.saveDrink(drinkDto);
    }
}
