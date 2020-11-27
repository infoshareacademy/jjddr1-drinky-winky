package com.infoshare.service;

import com.infoshare.dao.DrinkDao;
import com.infoshare.dto.DrinkDto;
import com.infoshare.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public DrinkDto addDrink(DrinkDto drinkDTO) {
        if (drinkDao.getDrinkList().stream().noneMatch(drink -> drink.getName().equals(drinkDTO.getName()))) {
            Drink drink = DrinkDto.dtoToDrink(drinkDTO);
            messageService.leaveMessage(1L, "Drink was added!");
            return DrinkDto.drinkToDTO(drinkDao.addDrink(drink));
        } else {
            messageService.leaveMessage(1L, "Nothing has happened, please change name.");
            return null;
        }
    }

    public DrinkDto getDrinkByName(String name) {
        Drink drinkByName = drinkDao.getDrinkByName(name);
        if (drinkByName != null) {
            return DrinkDto.drinkToDTO(drinkByName);
        }
        return null;
    }

    public DrinkDto getDrinkById(Long id) {
        Drink drinkById = drinkDao.getDrinkById(id);
        if (drinkById != null) {
            return DrinkDto.drinkToDTO(drinkById);
        }
        return null;
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

    public List<DrinkDto> getDrinkList() {
        return drinkDao.getDrinkList()
                .stream()
                .map(DrinkDto::drinkToDTO)
                .collect(Collectors.toList());
    }

    public Set<DrinkDto> getDrinkListByCategoryName(String name) {
        return getDrinkList().
                stream()
                .filter(drinkDTO -> drinkDTO.getCategory().getName().equalsIgnoreCase(name))
                .collect(Collectors.toSet());
    }

    public List<DrinkDto> getRequestDrinkList(int request, int size) {

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

    public List<DrinkDto> findDrinkListByName(String name) {
        if (name != null || !name.isBlank()) {
            List<DrinkDto> found = new ArrayList<>();
            List<DrinkDto> drinkList = getDrinkList();
            for (DrinkDto foundDrink : drinkList) {
                if (foundDrink.getName().toLowerCase().contains(name.toLowerCase())) {
                    found.add(foundDrink);
                }
            }
            return found;
        }
        return null;
    }

    public List<DrinkDto> findDrinkListByGlass(String glass) {
        if (glass != null || !glass.isBlank()) {
            List<DrinkDto> found = new ArrayList<>();
            List<DrinkDto> drinkList = getDrinkList();
            for (DrinkDto foundDrink : drinkList) {
                if (foundDrink.getGlassType().toLowerCase().contains(glass.toLowerCase())) {
                    found.add(foundDrink);
                }
            }
            return found;
        }
        return null;
    }

    public List<DrinkDto> findDrinkListByCategory(String category) {

        if (category != null || !category.isBlank()) {
            List<DrinkDto> found = new ArrayList<>();
            List<DrinkDto> drinkList = getDrinkList();
            for (DrinkDto foundDrink : drinkList) {
                if (foundDrink.getCategory().toString().toLowerCase().contains(category.toLowerCase())) {
                    found.add(foundDrink);
                }
            }
            return found;
        }
        return null;
    }

    public List<DrinkDto> findDrinkListByIngredient(String ingredient) {
        if (ingredient != null || !ingredient.isBlank()) {
            List<DrinkDto> found = new ArrayList<>();
            List<DrinkDto> drinkList = getDrinkList();
            for (DrinkDto foundDrink : drinkList) {
                if (foundDrink.getIngredientList().stream().anyMatch(d -> d.getName().toLowerCase().contains(ingredient.toLowerCase()))) {
                    found.add(foundDrink);
                }
            }
            return found;
        }
        return null;
    }

    public List<DrinkDto> findDrinkListByType(String type) {
        if (type != null || !type.isBlank()) {
            List<DrinkDto> found = new ArrayList<>();
            List<DrinkDto> drinkList = getDrinkList();
            for (DrinkDto foundDrink : drinkList) {
                if (foundDrink.getDrinkType().toLowerCase().contains(type.toLowerCase())) {
                    found.add(foundDrink);
                }
            }
            return found;
        }
        return null;
    }

    public List<DrinkDto> findDrinkListBasicOnAllValues(String input) {

        if (input != null || !input.isBlank()) {
            List<DrinkDto> found = new ArrayList<>();
            List<DrinkDto> drinkList = getDrinkList();
            for (DrinkDto foundDrink : drinkList) {

                //Name check
                if (foundDrink.getName().toLowerCase().contains(input.toLowerCase())) {
                    found.add(foundDrink);
                }
                //glass type check
                if (foundDrink.getGlassType().toLowerCase().contains(input.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
                //drink type check, if user want to find alcoholic or non alcoholic
                if (foundDrink.getDrinkType().toLowerCase().contains(input.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
                // category check
                if (foundDrink.getCategory().toString().toLowerCase().contains(input.toLowerCase())) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
                // trying to find an ingredient
                if (foundDrink.getIngredientList().stream().anyMatch(d -> d.getName().toLowerCase().contains(input.toLowerCase()))) {
                    if (!found.contains(foundDrink)) {
                        found.add(foundDrink);
                    }
                }
            }
            return found;
        }
        return null;
    }

}