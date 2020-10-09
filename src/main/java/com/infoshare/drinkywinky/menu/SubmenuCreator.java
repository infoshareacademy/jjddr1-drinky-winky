package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.model.Drink;
import com.infoshare.drinkywinky.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static com.infoshare.drinkywinky.menu.PropertiesMenu.SORT_TYPE;

/**
 * This class creates submenu for searching and printing as String
 * specific {@class Drink(s)}.Instance(s) of {@class Drink} are searched
 * depending on category of searching (e.g. names, categories or ingredients of drinks)
 * chosen in higher-level menu (main menu). Submenu can be built by passing
 * as a constructor parameter {List<String>}. Particular String elements of given List
 * are displayed one above the other as simple column menu with associated order number.
 * This specific assigned number allows to choose and print certain {@class Drink}
 * in simple way.
 * <p>
 * In the case of long list with many elements, submenu become divided into a pages.
 * This causes previewing whole submenu in comfortable way. Number of pages can be
 * easily manipulated by determination one of the class field NUMBER_OF_ELEMENTS_BY_PAGE.
 * Navigation between different pages is possible by clicking intuitive menu arrows.
 */
public class SubmenuCreator {

    protected static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    protected static final int NUMBER_OF_ELEMENTS_BY_PAGE = 7;
    protected static final String MENU_BUILDER = "│                                          │\n";
    private static final int MENU_WIDTH_1 = 37;
    private static final int MENU_WIDTH_2 = 33;
    protected int pageNumber = 0;
    private int numberOfPages;
    protected List<String> collectionOfSubmenuElements;
    protected int userChoiceInt;
    protected String userChoiceString;
    private static final String USER_DATA_BASE_PATH_NAME = "src/main/resources/drink list.json";

    protected static Object getSortType() {
        return SORT_TYPE;
    }

    /**
     * Constructor of SubmenuCreator with parameter {List<String>} is one and only
     * public method available in this class. It invokes all internal class private methods
     * allowing for building entire, fully functional submenu. Elements of given List
     * are displayed one above the other as simple column menu with associated order number.
     * Number of submenu pages is dependent on setting value one of the class
     * field "NUMBER_OF_ELEMENTS_BY_PAGE".
     * <p>
     * At the beginning constructor calls simple private countNumberOfMenuPages() method.
     * Further drawSubmenuContent() method is called. The second one is more complex
     * and invokes internally all the other private methods defined in class.
     *
     * @param listOfSubmenuElements List of String elements to be displayed in a structured
     *                              way as a submenu catchphrases.
     */
    public SubmenuCreator(List<String> listOfSubmenuElements) {
        this.collectionOfSubmenuElements = listOfSubmenuElements;
        if (SORT_TYPE.equals("DESC")) {
            listOfSubmenuElements.stream().sorted().collect(Collectors.toList());
            listOfSubmenuElements.sort(Comparator.reverseOrder());
            Repository.saveToFile(Repository.getInstance().getDrinkList(), USER_DATA_BASE_PATH_NAME);
            countNumberOfMenuPages();
            drawSubmenuContent();
        }
        if (SORT_TYPE.equals("ASC")) {
            listOfSubmenuElements.stream().sorted().collect(Collectors.toList());
            listOfSubmenuElements.sort(Comparator.naturalOrder());
            Repository.saveToFile(Repository.getInstance().getDrinkList(), USER_DATA_BASE_PATH_NAME);
            countNumberOfMenuPages();
            drawSubmenuContent();
        }
    }

    public void drawSubmenuContent() {
        do {
            STDOUT.info("\n┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[33m CHOOSE PROPER NUMBER OR OTHER OPTION  \u001b[0m │\n");
            STDOUT.info(MENU_BUILDER);
            fillingSubmenuByElements();
            STDOUT.info(MENU_BUILDER);
            showPageChangeArrows();
            STDOUT.info(MENU_BUILDER);
            STDOUT.info(MENU_BUILDER);
            STDOUT.info("│    Press \u001b[33mX\u001b[0m to return to the MAIN MENU    │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n\n");
            STDOUT.info("\u001b[33mYOUR CHOICE: \u001b[0m");
            chooseTheOption();
        } while (true);
    }

    protected void countNumberOfMenuPages() {
        numberOfPages = collectionOfSubmenuElements.size() / NUMBER_OF_ELEMENTS_BY_PAGE;
        if (collectionOfSubmenuElements.size() % NUMBER_OF_ELEMENTS_BY_PAGE != 0) {
            numberOfPages = collectionOfSubmenuElements.size() / NUMBER_OF_ELEMENTS_BY_PAGE + 1;
        }
    }

    protected void showPageChangeArrows() {
        STDOUT.info("│                Page {}/{}                  │\n", pageNumber + 1, numberOfPages);
        if (numberOfPages > 2 && pageNumber != 0 && pageNumber != numberOfPages - 1) {
            STDOUT.info("│   \u001b[33mP\u001b[0m <- Previous page    Next page -> \u001b[33mN\u001b[0m   │\n");
        }
        if (pageNumber == numberOfPages - 1 && numberOfPages > 1) {
            STDOUT.info("│   \u001b[33mP\u001b[0m <- Previous page                     │\n");
        }
        if (pageNumber == 0 && numberOfPages > 1) {
            STDOUT.info("│                         Next page -> \u001b[33mN\u001b[0m   │\n");
        }
    }

    protected void fillingSubmenuByElements() {
        for (int i = (1 + pageNumber * NUMBER_OF_ELEMENTS_BY_PAGE); i <= (NUMBER_OF_ELEMENTS_BY_PAGE + (pageNumber * NUMBER_OF_ELEMENTS_BY_PAGE)); i++) {
            if (i <= collectionOfSubmenuElements.size()) {
                int numberOfSpaces = MENU_WIDTH_1 - Integer.toString(i).length() - collectionOfSubmenuElements.get(i - 1).length();
                String whitespace = String.format("%1$" + numberOfSpaces + "s", "");
                STDOUT.info("│   \u001b[33m{}.\u001b[0m {}{}│\n", i, collectionOfSubmenuElements.get(i - 1), whitespace);
            } else {
                int numberOfSpaces2 = MENU_WIDTH_2 - Integer.toString(i).length();
                String whitespace = String.format("%1$" + numberOfSpaces2 + "s", "");
                STDOUT.info("│   \u001b[33m{}.\u001b[0m --- {}│\n", i, whitespace);
            }
        }
    }

    protected void chooseTheOption() {
        Scanner inn = new Scanner(System.in);
        if (inn.hasNextInt()) {
            userChoiceInt = inn.nextInt();
            if ((userChoiceInt >= (1 + pageNumber * NUMBER_OF_ELEMENTS_BY_PAGE)) && userChoiceInt <= (NUMBER_OF_ELEMENTS_BY_PAGE + pageNumber * NUMBER_OF_ELEMENTS_BY_PAGE) && userChoiceInt <= collectionOfSubmenuElements.size())
                chooseSpecificSubmenuElement();
            else {
                STDOUT.info("\n\u001b[31mNumber out of bounds!\nPlease write correct number!\u001b[0m\n");
                drawSubmenuContent();
            }
        } else {
            userChoiceString = inn.next();
            if ((userChoiceString.equalsIgnoreCase("N") | userChoiceString.equalsIgnoreCase("P") | userChoiceString.equalsIgnoreCase("X"))) {
                changePageOfSubmenu();
                quitToMainMenu();
            } else
                STDOUT.info("\n\u001b[31mWRONG INSTRUCTION! \nPlease write correct command!\u001b[0m\n");
        }
    }

    protected void changePageOfSubmenu() {
        if (userChoiceString.equalsIgnoreCase("N")) {
            if (pageNumber == numberOfPages - 1) {
                STDOUT.info("\n\u001b[31m It's LAST page, you cannot move forward!\u001b[0m\n");
            } else if (pageNumber < numberOfPages - 1) {
                pageNumber++;
            }
        }
        if (userChoiceString.equalsIgnoreCase("P")) {
            if (pageNumber == 0) {
                STDOUT.info("\n\u001b[31m It's FIRST page, you cannot move back!\u001b[0m\n");
            } else if (pageNumber > 0) {
                pageNumber--;
            }
        }
    }

    protected void quitToMainMenu() {
        if (userChoiceString.equalsIgnoreCase("X"))
            Menu.mainMenu();
    }

    protected void chooseSpecificSubmenuElement() {
        /**
         * @param listSelectedByName List of ALL {@class Drink} objects isolated from updated database by the NAME pointed by user
         * @param setSelectedByCategory Set of ALL {@class Drink} objects isolated from updated database by the CATEGORY pointed by user
         * @param listSelectedByIngredients List of ALL {@class Drink} objects isolated from updated database by the INGREDIENT pointed by user
         *
         */
        List<Drink> listSelectedByName = Repository.getInstance().getDrinkListByName(collectionOfSubmenuElements.get(userChoiceInt - 1));
        Set<Drink> setSelectedByCategory = Repository.getInstance().getDrinkByCategories(collectionOfSubmenuElements.get(userChoiceInt - 1));
        List<Drink> listSelectedByIngredients = Repository.getInstance().getListOfDrinkByIngredient(collectionOfSubmenuElements.get(userChoiceInt - 1));

        if (!listSelectedByName.isEmpty()) {
            STDOUT.info(String.valueOf(listSelectedByName));
        }
        if (!setSelectedByCategory.isEmpty()) {
            STDOUT.info(String.valueOf(setSelectedByCategory));
        }
        if (!listSelectedByIngredients.isEmpty()) {
            STDOUT.info(String.valueOf(listSelectedByIngredients));
        }
    }
}
