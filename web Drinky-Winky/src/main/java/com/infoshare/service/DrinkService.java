package com.infoshare.service;

import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class DrinkService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    DrinkDao drinkDao;

    public String addDrink(DrinkDTO drinkDTO) {
        if (drinkDao.getDrinkList().stream().noneMatch(drink -> drink.getName().equals(drinkDTO.getName()))) {
            Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
            drinkDao.addDrink(drink);
            return  "SUCCESS! THE DRINK HAS BEEN ADDED";
        }
        return "SOMETHING WENT WRONG! THE DRINK WITH THAT NAME ALREADY EXIST";
    }

    public void editDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
        drinkDao.editDrink(drink);
    }

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
        if (drinkDao.getDrinkList().stream().anyMatch(drink -> drink.getId().equals(id))) {
            drinkDao.deleteDrinkById(id);
            logger.info("Drink has been deleted");
        }
    }


    @Transactional
    public void deleteDrinkByName(String name) {
        if (drinkDao.getDrinkList().stream().anyMatch(drink -> drink.getName().equals(name))) {
            drinkDao.deleteDrinkByName(name);
            logger.info("Drink has been deleted");
        }
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
        int toIndex = request * size;

        if (toIndex > drinkDao.getDrinkList().size()) {
            toIndex = drinkDao.getDrinkList().size();
        }

        return drinkDao.getDrinkList()
                .stream()
                .map(DrinkDTO::drinkToDTO)
                .collect(Collectors.toList())
                .subList(fromIndex, toIndex);
    }

    @Transactional
    public Set<String> getUniqueGlassesNameList() {
        return drinkDao.getDrinkList()
                .stream()
                .map(Drink::getGlassType)
                .collect(Collectors.toSet());
    }

    public List<Drink> findRecipeByCategoryId(List<Long> ids) {
        return drinkDao.findDrinkByCategoryId(ids);
    }

    public List<Drink> findDrinkByCategoryIdAndIngredient(List<Long> ids, List<String> names) {
        return drinkDao.findDrinkByCategoryIdAndIngredient(ids, names);
    }
}
