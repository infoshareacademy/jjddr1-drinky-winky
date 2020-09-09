package RadekZadanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindByName {

    private List<String> drinkList;

    public FindByName() {
        this.drinkList = new ArrayList<>();
    }

    public List<String> findDrinkByName(String drinkInputName) {
        List<String> drinkListToFind = new ArrayList<>();
        for (String drinkIteration : drinkList) {
            if (drinkIteration.equals(drinkInputName)) {
                drinkListToFind.add(drinkIteration);
            }
        }
        if (drinkListToFind.isEmpty()) {
            return Collections.emptyList();
        }
        return drinkListToFind;
    }
}