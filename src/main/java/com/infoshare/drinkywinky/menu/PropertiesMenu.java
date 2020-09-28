package com.infoshare.drinkywinky.menu;



import com.infoshare.drinkywinky.properties.ConfigLoader;
import com.infoshare.drinkywinky.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.infoshare.drinkywinky.menu.Menu.SCANNER;


public class PropertiesMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void decision() {

        STDOUT.info("Are you sure to reset data base ?\n");
        String answer = SCANNER.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            List<String> drink = new ArrayList<String>();
            STDOUT.info("FILE RESTORED.\n");
            Repository.saveToNewFile();
            Menu.mainMenu();
        } else {
            STDOUT.info("Returning to properties menu.\n");
            propertiesMenu();
        }
    }

    public static void propertiesMenu() {

        int mainExitCode = 0;

        while ( mainExitCode != 4 ) {

            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m      CHOOSE OPTION FROM MENU       \u001b[0m    │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. Sort by ASC / DESC                  │\n");
            STDOUT.info("│   2. Data Formatter                      │\n");
            STDOUT.info("│   3. LOAD FROM ORIGINAL FILE             │\n");
            STDOUT.info("│    IT WILL ERASE ALL ADDITIONAL DATA     │\n");
            STDOUT.info("│  \u001b[36m 4. TO MAIN MENU                      \u001b[0m  │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOOSE : \n1. Sort by ASC   \n2. Sort by DESC \n ");
                    new ConfigLoader().loadAppConfig();
                    switch (ChoiceMenu.choiceMenu()) {
                        case 1:
                            STDOUT.info("ASC activated\n");
                            break;
                        default:
                            STDOUT.info("DESC activated\n");
                            break;
                    }
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Date Formatter  \n");

                    break;
                case 3:
                    STDOUT.info("┌──────────────────────────────────────────┐\n");
                    STDOUT.info("|    CHOSEN : 3. LOAD FROM ORIGINAL FILE   |\n");
                    STDOUT.info("│ DO NOT USE IF PROGRAM IS WORKING CORRECT │\n");
                    STDOUT.info("│         TYPE YES FOR CONFIRMATION        │\n");
                    STDOUT.info("│ TYPE NO TO ABORT AND RETURN TO MAIN MENU │\n");
                    STDOUT.info("└──────────────────────────────────────────┘\n");
                    SCANNER.nextLine();
                    decision();
                    break;
                case 4:
                    Menu.mainMenu();
                    mainExitCode = 4;
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