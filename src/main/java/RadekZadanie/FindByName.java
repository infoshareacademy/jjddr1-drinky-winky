package RadekZadanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FindByName {

    public List<String> drinkList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String drinkFromScanner = scanner.nextLine();

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

    List<DrinkList> functionDrink = drinkList.stream().filter(b -> b.getName().compareTo(drinkInputName)).collect(Collectors.toList());
    Logger logger = Logger.getLogger("main");
    logger.info(functionDrink.toString());

    }
}