package RadekZadanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FindByName {

    public List<DrinkList> drinkList = new ArrayList<>();

    // method to find a recipe by drinks' name
    public  List<DrinkList> findByName(String drinkFromScanner) {
            List<String> drinkListToFind = new ArrayList<>();
        for (String drinkElement : drinkList) {
            if (drinkElement.equals(drinkFromScanner)) {
                drinkListToFind.add(drinkElement);
            }
        }
        if (drinkListToFind.isEmpty()) {
            return Collections.emptyList();
        }
        return drinkListToFind;
    }
    // proba zrobienia tego funkcyjnie
    public void functionMethod(){
    List<DrinkList> functionDrink = drinkList.stream().filter(b -> b.getName().compareTo(inputFromScanner)).collect(Collectors.toList());
    Logger logger = Logger.getLogger("main");
    logger.info(functionDrink.toString());

    }
}