package com.infoshare.drinkywinky.menu.managment;

import com.infoshare.drinkywinky.menu.SubmenuCreator;
import com.infoshare.drinkywinky.repositories.Repository;

import java.util.List;

import static com.infoshare.drinkywinky.menu.Menu.SCANNER;

public class RemoveRecipe extends SubmenuCreator {
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
    public RemoveRecipe(List<String> listOfSubmenuElements) {
        super(listOfSubmenuElements);
    }

    public void drawSubmenuContent() {
        do {
            STDOUT.info("\n┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[33m CHOOSE NUMBER OF DRINK TO REMOVE  \u001b[0m     │\n");
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

    public void chooseSpecificSubmenuElement() {

        if ((userChoiceInt >= (1 + pageNumber * NUMBER_OF_ELEMENTS_BY_PAGE)) && userChoiceInt <= (collectionOfSubmenuElements.size())) {
            STDOUT.info("You have chosen drink to remove: \n\n");
            STDOUT.info(Repository.getInstance().getDrinkListByName(collectionOfSubmenuElements.get(userChoiceInt - 1)) + "\n");
            STDOUT.warn("\nAre you sure, you want to remove this drink?\n\n");
            STDOUT.info("Write \"Yes\" if you want remove, or \"No\" if you want cancel operation.\n\n");
            STDOUT.info(": ");
            String decision = SCANNER.next();
            if (decision.equalsIgnoreCase("yes")) {
                Repository.getInstance().remove(Repository.getInstance().getDrinkByName(collectionOfSubmenuElements.get(userChoiceInt - 1)));
                STDOUT.info("Drink has been removed!\n");
                new AddRecipeMenu().addRemoveRecipe();
            } else if (decision.equalsIgnoreCase("no")) {
                STDOUT.info("Drink has not been removed!\n");
                new AddRecipeMenu().addRemoveRecipe();
            } else {
                STDOUT.info("Wrong character!\n");
            }
        }
    }
}
