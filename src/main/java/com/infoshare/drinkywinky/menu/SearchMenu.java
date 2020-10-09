package com.infoshare.drinkywinky.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshare.drinkywinky.menu.Menu.WrongNumber;

public class SearchMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void secondMenu() {
        int mainExitCode = 0;

        while (mainExitCode != 4) {

            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m      CHOOSE OPTION FROM MENU       \u001b[0m    │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. Search for a drink by name          │\n");
            STDOUT.info("│   2. Search for a drink by ingredient    │\n");
            STDOUT.info("│   3. Search for a drink by category      │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[36m 4. TO MAIN MENU                   \u001b[0m     │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOSEN : 1. Search for a drink by name  \n");
                    new ShowSubmenu().showSubmenuByNames();
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Search for a drink by ingredient  \n");
                    new ShowSubmenu().showSubmenuByIngredients();
                    break;
                case 3:
                    STDOUT.info(" CHOSEN : 3. Search for a drink by category  \n");
                    new ShowSubmenu().showSubmenuByCategories();
                    break;
                case 4:
                    STDOUT.info(" Welcome to main menu \n");
                    Menu.mainMenu();

                    mainExitCode = 4;
                    break;
                default:
                    WrongNumber();
                    break;
            }
        }
    }
}