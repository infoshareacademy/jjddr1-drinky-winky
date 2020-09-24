package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    /**
     * Method which displays main Menu of the application
     */
    public static void mainMenu() {
        int mainExitCode = 0;

        STDOUT.info("┌──────────────────────────────────────────┐\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│ \u001b[32m   WELCOME TO MANAGE DRINK APLICATION    \u001b[0m│\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│           (c) Drinky-Winky               │\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("└──────────────────────────────────────────┘\n");
        STDOUT.info("\n");
        STDOUT.info("\n");

        while (mainExitCode != 7) {

            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m      CHOOSE OPTION FROM MENU       \u001b[0m   │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. List of all recipes                 │\n");
            STDOUT.info("│   2. Search for specific recipe          │\n");
            STDOUT.info("│   3. Add/remove recipe                   │\n");
            STDOUT.info("│   4. Manage yours favorites              │\n");
            STDOUT.info("│   5. Search for drink by category        │\n");
            STDOUT.info("│   6. Edit configuration                  │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[36m 7. END OF PROGRAM                    \u001b[0m  │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOSEN : 1. List of all recipes   \n");
                    STDOUT.info(String.valueOf(Utils.getNamesOfAllDrink()));
                    new ShowByCategory().showByCategory();
                    //TODO PRINT ALL EVENTS
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Search for specific recipe\n");
                    String userDrinkName;
                    STDOUT.info("Enter name of recipe: ");
                    userDrinkName = SCANNER.next();
                    STDOUT.info(String.valueOf(Repository.getInstance().getDrinkList().getDrinkByName(userDrinkName)));
                    new ShowByCategory().showByCategory();
                    //TODO metoda 2
                    break;
                case 3:
                    //TODO metoda 3
                    STDOUT.info(" CHOSEN : 3. Add/remove recipe  \n");
                    new ShowByCategory().showByCategory();
                    break;
                case 4:
                    //TODO metoda 3
                    STDOUT.info(" CHOSEN : 4. Manage yours favorites \n");
                    new ShowByCategory().showByCategory();
                    break;
                case 5:
                    //TODO metoda 3
                    STDOUT.info(" CHOSEN : 5. Search for drink by category\n");
                    new ShowByCategory().showByCategory();
                    break;
                case 6:
                    //TODO metoda 3
                    STDOUT.info(" CHOSEN : 6. Edit configuration      \n");
                    new ShowByCategory().showByCategory();
                    break;
                case 7:
                    STDOUT.info("\n");
                    STDOUT.info("┌──────────────────────────────────────────┐\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("│       \u001b[35m       SEE YOU LATER!      \u001b[0m        │\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("└──────────────────────────────────────────┘\n");
                    STDOUT.info("\n");
                    mainExitCode = 7;
                    break;
                case 0:
                    break;
                default:
                    STDOUT.info("\n");
                    STDOUT.info("┌──────────────────────────────────────────┐\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("│       \u001b[31mYOU HAVE ENTERED WRONG NUMBER! \u001b[0m    │\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("│               TRY AGAIN!                 │\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("└──────────────────────────────────────────┘\n");
                    STDOUT.info("\n");
            }
        }
    }
}