package com.infoshare.drinkywinky.drinkslibrary;

import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfDrinks {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    public static final int NUMBER_OF_DRINKS_BY_PAGE = 5;
    private int pageNumber = 0;

    public void alphabeticalMenu() {
        List<String> defaultList = Utils.getNamesOfAllDrink();
        List<String> alphabeticalList = defaultList.stream().sorted().collect(Collectors.toList());
        int numberOfPages = defaultList.size() / NUMBER_OF_DRINKS_BY_PAGE + 1;

        STDOUT.info("\n");
        STDOUT.info("┌──────────────────────────────────────────┐\n");
        STDOUT.info("│ \u001b[33m CHOOSE NUMBER OF DRINK OR OTHER OPTION \u001b[0m │\n");
        STDOUT.info("│           \u001b[33m \u001b[0m                              │\n");
        STDOUT.info("│   X. BACK TO THE MAIN MENU               │\n");
        STDOUT.info("│                                          │\n");
        for (int i = (1 + pageNumber * NUMBER_OF_DRINKS_BY_PAGE); i <= (NUMBER_OF_DRINKS_BY_PAGE + (pageNumber * NUMBER_OF_DRINKS_BY_PAGE)); i++) {
            if (i <= defaultList.size()) {
                int numberOfSpaces = 37 - Integer.toString(i).length() - alphabeticalList.get(i - 1).length();
                String whitespace = String.format("%1$" + numberOfSpaces + "s", "");
                STDOUT.info("│   {}. {}{}│\n", i, alphabeticalList.get(i - 1), whitespace);
            } else {
                int numberOfSpaces2 = 33 - Integer.toString(i).length();
                String whitespace = String.format("%1$" + numberOfSpaces2 + "s", "");
                STDOUT.info("│   {}. --- {}│\n", i, whitespace);
            }
        }
        STDOUT.info("│                                          │\n");
        STDOUT.info("│                  Page {}/{}                │\n", pageNumber + 1, numberOfPages);
        STDOUT.info("│   P <- Previous page    Next page -> N   │\n");
        STDOUT.info("└──────────────────────────────────────────┘\n");

        STDOUT.info("\n");
        STDOUT.info("CHOOSE NUMBER OF DRINK, CHANGE PAGE OR GO TO THE MAIN MENU: ");

    }

    public void changePage() {

    }

    public static void main(String[] args) {
        ListOfDrinks list = new ListOfDrinks();
        list.alphabeticalMenu();
    }
}
