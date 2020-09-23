package com.infoshare.drinkywinky.drinkslibrary;

import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static com.infoshare.drinkywinky.menu.Menu.SCANNER;

public class ListOfDrinks {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    public static final int NUMBER_OF_DRINKS_BY_PAGE = 5;
    private int pageNumber = 0;
    private String in;
    private int numberOfPages;

    public void alphabeticalMenu() {
        List<String> defaultList = Utils.getNamesOfAllDrink();
        List<String> alphabeticalList = defaultList.stream().sorted().collect(Collectors.toList());
        numberOfPages = defaultList.size() / NUMBER_OF_DRINKS_BY_PAGE;
        if (defaultList.size() % NUMBER_OF_DRINKS_BY_PAGE != 0) {
            numberOfPages = defaultList.size() / NUMBER_OF_DRINKS_BY_PAGE + 1;
        }

        do {
            STDOUT.info("\n");
            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│ \u001b[33m CHOOSE NUMBER OF DRINK OR OTHER OPTION \u001b[0m │\n");
            STDOUT.info("│                                          │\n");
            for (int i = (1 + pageNumber * NUMBER_OF_DRINKS_BY_PAGE); i <= (NUMBER_OF_DRINKS_BY_PAGE + (pageNumber * NUMBER_OF_DRINKS_BY_PAGE)); i++) {
                if (i <= defaultList.size()) {
                    //TODO Magic numbers
                    int numberOfSpaces = 37 - Integer.toString(i).length() - alphabeticalList.get(i - 1).length();
                    String whitespace = String.format("%1$" + numberOfSpaces + "s", "");
                    STDOUT.info("│   \u001b[33m{}.\u001b[0m {}{}│\n", i, alphabeticalList.get(i - 1), whitespace);
                } else {
                    int numberOfSpaces2 = 33 - Integer.toString(i).length();
                    String whitespace = String.format("%1$" + numberOfSpaces2 + "s", "");
                    STDOUT.info("│   \u001b[33m{}.\u001b[0m --- {}│\n", i, whitespace);
                }
            }
            STDOUT.info("│                                          │\n");
            STDOUT.info("│                Page {}/{}                  │\n", pageNumber + 1, numberOfPages);
            if (numberOfPages > 2 && pageNumber != 0 && pageNumber != numberOfPages - 1) {
                STDOUT.info("│   \u001b[33mP\u001b[0m <- Previous page    Next page -> \u001b[33mN\u001b[0m   │\n");
            }
            if (pageNumber == numberOfPages - 1 && numberOfPages>1) {
                STDOUT.info("│   \u001b[33mP\u001b[0m <- Previous page                     │\n");
            }
            if (pageNumber == 0  && numberOfPages>1) {
                STDOUT.info("│                         Next page -> \u001b[33mN\u001b[0m   │\n");
            }
            STDOUT.info("│                                          │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│    Press \u001b[33mX\u001b[0m to return to the MAIN MENU    │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");

            STDOUT.info("\n");
            STDOUT.info("\u001b[33mYOUR CHOICE: \u001b[0m");
            chooseTheOption();
        } while (true);
    }


    private void chooseTheOption() {
        in = SCANNER.next();
        changePage();
        quitToMainMenu();
    }

    private void changePage() {
        if (in.equalsIgnoreCase("N")) {
            if (pageNumber == numberOfPages - 1) {
                STDOUT.info("\n\u001b[31m It's LAST page, you cannot move forward!\u001b[0m\n");
            } else if (pageNumber < numberOfPages - 1) {
                pageNumber++;
            }
        }
        if (in.equalsIgnoreCase("P")) {
            if (pageNumber == 0) {
                STDOUT.info("\n\u001b[31m It's FIRST page, you cannot move back!\u001b[0m\n");
            } else if (pageNumber > 0) {
                pageNumber--;
            }
        }
    }

    private void quitToMainMenu() {
        if (in.equalsIgnoreCase("X")) {
            Menu.mainMenu();
        }
    }

//    public List<Drink> getDrinkByCategory(String category) {
//        return allDrink
//                .stream()
//                .filter(e -> e.getCategory().equalsIgnoreCase(category))
//                .collect(Collectors.toList());


    public static void main(String[] args) {
        ListOfDrinks list = new ListOfDrinks();
        list.alphabeticalMenu();
    }
}
