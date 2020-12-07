package com.infoshare.dao;

import com.infoshare.model.Drink;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DrinkDao {

    @PersistenceContext
    EntityManager entityManager;

    public Drink addDrink(Drink drink) {
        entityManager.persist(drink);
        return drink;
    }

    public Drink getDrinkByName(String name) {
        TypedQuery<Drink> query = entityManager.createNamedQuery(Drink.GET_DRINK_BY_NAME, Drink.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    public Drink getDrinkById(Long id) {
        return entityManager.find(Drink.class, id);
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
