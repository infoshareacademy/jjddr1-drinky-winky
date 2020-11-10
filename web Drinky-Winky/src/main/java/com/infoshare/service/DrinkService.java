package com.infoshare.service;

import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@RequestScoped
public class DrinkService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    DrinkDao drinkDao;
    @Inject
    MessageService messageService;

    public DrinkDTO addDrink(DrinkDTO drinkDTO) {
        if (drinkDao.getDrinkList().stream().noneMatch(drink -> drink.getName().equals(drinkDTO.getName()))) {
            Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
            messageService.leaveMessage(1L, "Drink was added!");
            return DrinkDTO.drinkToDTO(drinkDao.addDrink(drink));
        } else {
            messageService.leaveMessage(1L, "Nothing has happened, please change name.");
            return null;
        }
    }

    public void editDrink(DrinkDTO drinkDTO) {
        Drink drink = DrinkDTO.DtoToDrink(drinkDTO);
        drinkDao.editDrink(drink);
    }

    public DrinkDTO getDrinkByName(String name) {
        Drink drinkByName = drinkDao.getDrinkByName(name);
        if (drinkByName != null) {
            return DrinkDTO.drinkToDTO(drinkByName);
        }
        return null;
    }

    public DrinkDTO getDrinkById(Long id) {
        Drink drinkById = drinkDao.getDrinkById(id);
        if (drinkById != null) {
            return DrinkDTO.drinkToDTO(drinkById);
        }
        return null;
    }

    public void deleteDrinkById(Long id) {
        if (drinkDao.getDrinkList().stream().anyMatch(drink -> drink.getId().equals(id))) {
            drinkDao.deleteDrinkById(id);
            logger.info("Drink has been deleted");
        }
    }

    public void deleteDrinkByName(String name) {
        if (drinkDao.getDrinkList().stream().anyMatch(drink -> drink.getName().equals(name))) {
            drinkDao.deleteDrinkByName(name);
            logger.info("Drink has been deleted");
            messageService.leaveMessage(1L, "Drink was deleted!!!");
        } else {
            messageService.leaveMessage(1L, "OMG! Nothing happened!");
        }
    }

    public List<DrinkDTO> getDrinkList() {
        return drinkDao.getDrinkList()
                .stream()
                .map(DrinkDTO::drinkToDTO)
                .collect(Collectors.toList());
    }

    public Set<DrinkDTO> getDrinkListByCategoryName(String name) {
        return getDrinkList().
                stream()
                .filter(drinkDTO -> drinkDTO.getCategory().getName().equalsIgnoreCase(name))
                .collect(Collectors.toSet());
    }

    public List<DrinkDTO> getRequestDrinkList(int request, int size) {

        int fromIndex = (request - 1) * size;
        int toIndex = request * size;

        if (toIndex > drinkDao.getDrinkList().size()) {
            toIndex = drinkDao.getDrinkList().size();
        }
        return getDrinkList().subList(fromIndex, toIndex);
    }

    public Set<String> getUniqueGlassesNameList() {
        return drinkDao.getDrinkList()
                .stream()
                .map(Drink::getGlassType)
                .collect(Collectors.toSet());
    }

}
