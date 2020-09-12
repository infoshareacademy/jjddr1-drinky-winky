package RadekZadanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindByIngridient extends FindByName{

    private List<DrinkList> ingridientList = new ArrayList<>();


        // method to find a recipe by drink's ingridient
    public List<String> findByIngridient(String ingridentFromScanner) {
        List<String> drinksByIngridientList = new ArrayList<>();
        for (String ingridientElement : ingridientList) {
            if (ingridientElement.equals((ingridentFromScanner))) {
               String drinkByIngridient = drinkList.getName();
            }
        }
        if (drinksByIngridientList.isEmpty()) {
            return Collections.emptyList();
        }
        return drinkByIngridient;
    }

