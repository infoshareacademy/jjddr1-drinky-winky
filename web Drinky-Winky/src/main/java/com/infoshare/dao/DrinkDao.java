package com.infoshare.dao;

import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public Drink editDrink(Drink drink) {
        entityManager.merge(drink);
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

    public void deleteDrinkById(Long id) {
        Drink drink = getDrinkById(id);
        if (drink != null) {
            entityManager.remove(drink);
        }
    }

    public void deleteDrinkByName(String name) {
        Drink drink = getDrinkByName(name);
        if (drink != null) {
            entityManager.remove(drink);
        }
    }

    public List<Drink> getDrinkList() {
        TypedQuery<Drink> query = entityManager.createNamedQuery(Drink.GET_DRINK_LIST, Drink.class);
        return query.getResultList();
    }

    public List<Drink> findDrinkByCategoryId(List<Long> ids) {
        Query query = entityManager.createNamedQuery("Category.findCategoryById");
        query.setParameter("ids", ids);
        List<Category> categories = query.getResultList();

        Query recipeQuery = entityManager.createNamedQuery(Drink.GET_RECIPE_BY_CATEGORY);
        recipeQuery.setParameter("categories", categories);
        return recipeQuery.getResultList();
    }

    public List<Drink> findDrinkByCategoryIdAndIngredient(List<Long> ids, List<String> names) {

        Query query = entityManager.createNamedQuery("Category.findCategoryById");
        query.setParameter("ids", ids);
        List<Category> categories = query.getResultList();
        Query queryIngredient = entityManager.createNamedQuery("Ingredient.findIngredientByName");
        queryIngredient.setParameter("names", names);
        List<Ingredient> ingredients = queryIngredient.getResultList();
        long namesLenght = (names).size();

        Query drinkQuery = entityManager.createQuery(Drink.GET_DRINK_BY_CATEGORY_AND_INGREDIENT);
        drinkQuery.setParameter("categories", categories);
        drinkQuery.setParameter("names", names);
        drinkQuery.setParameter("namesLength", namesLenght);
        return drinkQuery.getResultList();
    }
}

//      if (drinkToUpdate != null) {
//              drinkToUpdate.setName(drinkDTO.getName());
//              drinkToUpdate.setCustom(drinkDTO.getCustom());
//              drinkToUpdate.setApproved(drinkDTO.getApproved());
//              drinkToUpdate.setRecipe(drinkDTO.getRecipe());
//              drinkToUpdate.setDrinkType(drinkDTO.getDrinkType());
//              drinkToUpdate.setGlassType(drinkDTO.getGlassType());
//              drinkToUpdate.setModificationDate(drinkDTO.getModificationDate());
//              drinkToUpdate.setImageUrl(drinkDTO.getImageUrl());
//              drinkToUpdate.setCategory(drinkDTO.getCategory());
//              drinkToUpdate.setIngredientList(drinkDTO.getIngredientList());
//              drinkToUpdate.setUsers(drinkDTO.getUsers());