package com.infoshare.drinkywinky.menu.favourite;

import com.infoshare.drinkywinky.menu.ChoiceMenu;
import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.model.DrinkList;
import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshare.drinkywinky.menu.Menu.wrongNumber;

public class ManageFavourite {
    private static DrinkList drinkList;
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void addRemoveRecipe() {

        int mainExitCode = 0;

        while (mainExitCode != 3) {
            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│    \u001b[45m      ADD OR REMOVE FAVOURITE      \u001b[0m   │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. Show favourite drink list           │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   2. Add new favourite drink             │\n");
            STDOUT.info("│   3. Remove from favourite               │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[36m 4. TO MAIN MENU                   \u001b[0m     │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOSEN : 1. Show favourite drink list   \n");
                    new Favourites(Utils.getNamesOfFavouriteDrinkList(Repository.getInstance().getFavouriteDrinkList()));
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Add new drink  \n");
                    new AddFavourite(Utils.getNamesOfAllDrink(Repository.getInstance().getDrinkList()));
                    break;
                case 3:
                    STDOUT.info(" CHOSEN : 3. Remove drink  \n");
                    new RemoveFavourite(Utils.getNamesOfFavouriteDrinkList(Repository.getInstance().getFavouriteDrinkList()));
                    break;
                case 4:
                    STDOUT.info(" CHOSEN : 4. Back to menu  \n");
                    Menu.mainMenu();
                    mainExitCode = 3;
                    break;
                default:
                    wrongNumber();
                    break;
            }
        }
    }
}
