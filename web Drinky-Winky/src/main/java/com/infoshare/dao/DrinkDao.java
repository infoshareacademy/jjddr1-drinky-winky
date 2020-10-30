package com.infoshare.dao;

import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class DrinkDao {

    @PersistenceContext
    EntityManager entityManager;

    public void loadDrink(List<Drink> drinkList) {
        for (Drink drink : drinkList) {
            entityManager.persist(drink);
        }
    }

    public void addDrink(Drink drink) {
        entityManager.persist(drink);
    }

    public Drink editDrink(Drink drink) {
        return entityManager.merge(drink);
    }

    public Drink getDrinkByName(String name) {
        return entityManager.find(Drink.class, name);
    }

    public Drink getDrinkById(Long id) {
        return entityManager.find(Drink.class, id);
    }

    public void deleteRecipeById(Long id) {
        Drink drink = getDrinkById(id);
        if (drink != null) {
            entityManager.remove(drink);
        }
    }

    public List<Drink> getDrinkList() {
        Query query = entityManager.createNamedQuery("Drink.getDrinkList");
        return query.getResultList();
    }

    public List<String> findDrinkByCategoryIdAndIngredient(List<Long> ids, List<String> names) {

        Query query = entityManager.createNamedQuery("Category.findCategoryById");
        query.setParameter("ids", ids);
        List<Category> categories = query.getResultList();
        Query queryIngredient = entityManager.createNamedQuery("Ingredient.findIngredientByName");
        queryIngredient.setParameter("names", names);
        List<Ingredient> ingredients = queryIngredient.getResultList();

        Query drinkQuery = entityManager.createQuery(Drink.GET_DRINK_BY_CATEGORY_AND_INGREDIENT);
        drinkQuery.setParameter("categories", categories);
        drinkQuery.setParameter("names", names);
        return drinkQuery.getResultList();
    }

//    public List<String> randomDrinkUrlSearcher(List<Drink> drinkList, String image_url, String name) {

}
