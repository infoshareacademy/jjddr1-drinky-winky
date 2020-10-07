package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.properties.AppConfig;
import com.infoshare.drinkywinky.properties.ConfigLoader;
import com.infoshare.drinkywinky.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.infoshare.drinkywinky.menu.Menu.SCANNER;

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
    public static final int NUMBER_OF_ELEMENTS_BY_PAGE = 7;
    public static final String MENU_BUILDER = "│                                          │\n";
    public static final int MENU_WIDTH_1 = 37;
    public static final int MENU_WIDTH_2 = 33;
    protected int pageNumber = 0;
    protected String in;
    private int numberOfPages;
    private int trigger;
    private static Object SORT_TYPE = AppConfig.recipeSortType;
    protected List<String> collectionOfSubmenuElements;

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
        //TODO -> DO I NEED 2 LINES BELOW? (Config Lines) HOW TO MAKE IT WORKING?
        ConfigLoader config = new ConfigLoader();
        config.loadAppConfig();
        countNumberOfMenuPages();
        drawSubmenuContent();

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

            //TODO NULL POINTER EXCEPTION BY INPUT WRONG LETTER
            chooseTheOption();

        } while (true);
    }

    public void countNumberOfMenuPages() {
        numberOfPages = collectionOfSubmenuElements.size() / NUMBER_OF_ELEMENTS_BY_PAGE;
        if (collectionOfSubmenuElements.size() % NUMBER_OF_ELEMENTS_BY_PAGE != 0) {
            numberOfPages = collectionOfSubmenuElements.size() / NUMBER_OF_ELEMENTS_BY_PAGE + 1;
        }
    }

    public void showPageChangeArrows() {
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


    public void fillingSubmenuByElements() {
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

    public void chooseTheOption() {
        in = SCANNER.next();
        trigger = 1;
        changePageOfSubmenu();
        quitToMainMenu();
        if (trigger == 1) {
            chooseSpecificSubmenuElement();
        }
    }

    public void changePageOfSubmenu() {
        if (in.equalsIgnoreCase("N")) {
            if (pageNumber == numberOfPages - 1) {
                STDOUT.info("\n\u001b[31m It's LAST page, you cannot move forward!\u001b[0m\n");
            } else if (pageNumber < numberOfPages - 1) {
                pageNumber++;
            }
            trigger = 0;
        }

        if (in.equalsIgnoreCase("P")) {
            if (pageNumber == 0) {
                STDOUT.info("\n\u001b[31m It's FIRST page, you cannot move back!\u001b[0m\n");
            } else if (pageNumber > 0) {
                pageNumber--;
            }
            trigger = 0;
        }
    }

    public void quitToMainMenu() {
        if (in.equalsIgnoreCase("X")) {

            Menu.mainMenu();
            trigger = 0;
        }
    }

    public void chooseSpecificSubmenuElement() {
        if ((Integer.parseInt(in) >= (1 + pageNumber * NUMBER_OF_ELEMENTS_BY_PAGE))
                && (Integer.parseInt(in) <=
                (collectionOfSubmenuElements.size()))) {
            STDOUT.info(String.valueOf(Repository.getInstance().getDrinkListByName(collectionOfSubmenuElements.get(Integer.parseInt(in) - 1))));

        }
    }
}
