package com.infoshare.drinkywinky.menu.managment;

import com.infoshare.drinkywinky.menu.ChoiceMenu;
import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AddRecipeMenu {

    private static DrinkList drinkList;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void addRemoveRecipe() {

        int mainExitCode = 0;

        while (mainExitCode != 3) {

            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m              ADD OR REMOVE  \u001b[0m           │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. Add new recipe                      │\n");
            STDOUT.info("│   2. Remove old recipe                   │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[36m 3. TO MAIN MENU                   \u001b[0m     │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOSEN : 1. Add new drink  \n");
                    new InputDataUser().scannerInput();
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Remove drink  \n");
                    new RemoveRecipe(Utils.getNamesOfAllDrink(Repository.getInstance().getDrinkList()));
                    break;
                case 3:
                    STDOUT.info(" CHOSEN : 3. Back to menu  \n");
                    Menu.mainMenu();
                    mainExitCode = 3;
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
                    break;
            }
        }
    }
}
