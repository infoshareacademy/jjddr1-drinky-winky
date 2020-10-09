package com.infoshare.drinkywinky.menu.managment;

import com.infoshare.drinkywinky.menu.ChoiceMenu;
import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshare.drinkywinky.menu.Menu.WrongNumber;

public class AddRecipeMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void addRemoveRecipe() {

        int mainExitCode = 0;

        while (mainExitCode != 3) {
            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m           ADD OR REMOVE              \u001b[0m  │\n");
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
                    WrongNumber();
                    break;
            }
        }
    }
}
