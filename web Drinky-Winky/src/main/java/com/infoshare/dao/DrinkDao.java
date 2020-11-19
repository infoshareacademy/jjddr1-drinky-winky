package com.infoshare.dao;

import com.infoshare.model.Drink;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class DrinkDao {

    @PersistenceContext
    EntityManager entityManager;

    public Drink addDrink(Drink drink) {
        entityManager.persist(drink);
        return drink;
    }

    //TODO PLEASE FIX IT id require
    public Drink editDrink(Drink drink) {
        entityManager.merge(drink);
        return drink;
    }

    public Drink getDrinkByName(String name) {
        TypedQuery<Drink> query = (TypedQuery<Drink>) entityManager.createNamedQuery(Drink.GET_DRINK_BY_NAME, Drink.class).getResultStream().collect(Collectors.toSet()).stream().findFirst().orElseThrow();
            return query.getSingleResult();
    }


    public Drink getDrinkById(Long id) {
        return entityManager.find(Drink.class, id);
    }

    public Boolean deleteDrinkById(Long id) {
        Drink drink = getDrinkById(id);
        if (drink != null) {
            entityManager.remove(drink);
            return true;
        }
        return false;
    }

    public Boolean deleteDrinkByName(String name) {
        Drink drink = getDrinkByName(name);
        if (drink != null) {
            entityManager.remove(drink);
            return true;
        }
        return false;
    }

    public List<Drink> getDrinkList() {
        TypedQuery<Drink> query = entityManager.createNamedQuery(Drink.GET_DRINK_LIST, Drink.class);
        return query.getResultList();
    }
}
