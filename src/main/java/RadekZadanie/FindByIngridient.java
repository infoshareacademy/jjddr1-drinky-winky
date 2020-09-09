package RadekZadanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindByIngridient {
    private List<String> ingridientList;

    public FindByIngridient() {
        this.ingridientList = ingridientList;
    }

    public List<String> findDrinkByIngridient(String ingridientInputName) {
        List<String> drinksByIngridientList = new ArrayList<>();
        for (String ingridientIteration : ingridientList) {
            if (ingridientIteration.equals((ingridientInputName))) {
                drinksByIngridientList.add(ingridientInputName);
            }
        }
        if (drinksByIngridientList.isEmpty()) {
            return Collections.emptyList();
        }
        return drinksByIngridientList;
    }
}
