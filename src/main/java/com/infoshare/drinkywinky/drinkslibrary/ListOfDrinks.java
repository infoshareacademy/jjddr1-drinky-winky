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
    private int pageNumber = 0;

    public void alphabeticalMenu() {
        List<String> defaultList = Utils.getNamesOfAllDrink();
        List<String> alphabeticalList = defaultList.stream().sorted().collect(Collectors.toList());
        int numberOfPages = defaultList.size()%5+1;

        STDOUT.info("\n");
        STDOUT.info("┌──────────────────────────────────────────┐\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│ \u001b[33m CHOOSE NUMBER OF DRINK OR OTHER OPTION \u001b[0m │\n");
        STDOUT.info("│           \u001b[33m \u001b[0m                              │\n");
        for (int i = (1 + pageNumber * 5); i <= (5 + pageNumber * 5); i++) {
            int numberOfSpaces=37-Integer.toString(i).length()-alphabeticalList.get(i - 1).length();
            String whitespace = String.format("%1$"+numberOfSpaces+"s", "");
            STDOUT.info("│   {}. {}{}│\n", i, alphabeticalList.get(i - 1),whitespace);
        }
        STDOUT.info("│                                          │\n");
        STDOUT.info("│   N -> go to the NEXT PAGE               │\n");
        STDOUT.info("│   P -> go to the PREVIOUS PAGE           │\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│  \u001b[36m 7. BACK TO MAIN MENU\u001b[0m                   │\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│                                 Page {}/{} │\n",pageNumber+1,numberOfPages);
        STDOUT.info("└──────────────────────────────────────────┘\n");
        STDOUT.info("\n");
        STDOUT.info("CHOOSE NUMBER: ");

    }

    public void changePage() {

    }

    public static void main(String[] args) {
        ListOfDrinks list = new ListOfDrinks();
        list.alphabeticalMenu();
    }
}
