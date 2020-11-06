package com.infoshare.service;

import com.infoshare.dao.CategoryDao;
import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.CategoryDto;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class DrinkService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    DrinkDao drinkDao;

    @EJB
    CategoryDao categoryDaoo;

    public void addDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
        drinkDao.addDrink(drink);
    }

    public void editDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
        drinkDao.editDrink(drink); }

    @Transactional
    public DrinkDTO getDrinkByName(String name) {
        Drink drinkByName = drinkDao.getDrinkByName(name);
        if (drinkByName != null) {
            return DrinkDTO.drinkToDTO(drinkByName);
        }
        return null;
    }

    @Transactional
    public DrinkDTO getDrinkById(Long id) {
        Drink drinkById = drinkDao.getDrinkById(id);
        if (drinkById != null) {
            return DrinkDTO.drinkToDTO(drinkById);
        }
        return null;
    }

    @Transactional
    public void deleteDrinkById(Long id) {
        drinkDao.deleteDrinkById(id);
        logger.info("Drink has been deleted");
    }

    @Transactional
    public void deleteDrinkByName(String name) {
        drinkDao.deleteDrinkByName(name);
        logger.info("Drink has been deleted");
    }

    @Transactional
    public List<DrinkDTO> getDrinkList() {
        return drinkDao.getDrinkList()
                .stream()
                .map(DrinkDTO::drinkToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<DrinkDTO> getRequestDrinkList(int request, int size) {

        int fromIndex = (request - 1) * size;
        int toIndex = request * size - 1;

        return drinkDao.getDrinkList()
                .stream()
                .map(DrinkDTO::drinkToDTO)
                .collect(Collectors.toList())
                .subList(fromIndex, toIndex);
    }

    public List<Drink> findRecipeByCategoryId(List<Long> ids) {
        return drinkDao.findDrinkByCategoryId(ids);
    }

    public List<Drink> findDrinkByCategoryName(String name) { return categoryDaoo.findCategoryByNames(name);}

    public List<Drink> findDrinkByCategoryIdAndIngredient(List<Long> ids, List<String> names) {
        return drinkDao.findDrinkByCategoryIdAndIngredient(ids, names);
    }
}
