package com.infoshare.dao;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DrinkDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //<---- TODO w jaki sposob unikac null, servlet moze spr czy id jest poprawny, wyjatek zamiast null (np illegal state) badz optional od drink
    public Drink findById(Long id) {
        return entityManager.find(Drink.class, id);
    }

    public DrinkDTO saveDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.createModelFromDTO(drinkDTO);
        entityManager.persist(drink);
        return DrinkDTO.createDTOFromModel(drink);
    }

    public Drink edit(Long id, DrinkDTO drinkDTO) {
        Drink toEdit = entityManager.find(Drink.class, id);
        if (toEdit != null) {
            toEdit.setDrinkName(drinkDTO.getDrinkName());
            toEdit.setIngredients(drinkDTO.getIngredients());
            entityManager.merge(toEdit);
            return toEdit;
        }
        return null;
    }

    public boolean remove(Long id) {
        Drink toRemove = entityManager.find(Drink.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public List<Drink> getDrinkList() {
        TypedQuery<Drink> query = entityManager.createQuery("SELECT d FROM Drink d", Drink.class);
        return query.getResultList();
    }
}
