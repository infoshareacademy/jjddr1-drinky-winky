package com.infoshare.dao;

import com.infoshare.dto.DrinkDto;
import com.infoshare.model.Drink;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DrinkDao {

    @PersistenceContext
    private EntityManager entityManager;

    public DrinkDto saveDrink(DrinkDto drinkDto) {
        Drink drink = DrinkDto.DtoToDrink.apply(drinkDto);
        entityManager.persist(drink);
        return DrinkDto.DrinkToDto.apply(drink);
    }
}
