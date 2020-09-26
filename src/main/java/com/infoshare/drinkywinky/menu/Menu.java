package com.infoshare.drinkywinky.menu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Scanner;

public class Menu {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void intro() {

        STDOUT.info("┌──────────────────────────────────────────┐\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│ \u001b[32m   WELCOME TO MANAGE DRINK APLICATION    \u001b[0m│\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("│           (c) Drinky-Winky               │\n");
        STDOUT.info("│                                          │\n");
        STDOUT.info("└──────────────────────────────────────────┘\n");
        STDOUT.info("\n");
        STDOUT.info("\n");
    }

    public static void mainMenu() {
        int mainExitCode = 0;

        while (mainExitCode != 5) {

            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m      CHOOSE OPTION FROM MENU        \u001b[0m   │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. Search for drink                    │\n");
            STDOUT.info("│   2. Add/remove recipe                   │\n");
            STDOUT.info("│   3. Manage yours favorites              │\n");
            STDOUT.info("│   4. Edit configuration                  │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[36m 5. END OF PROGRAM                    \u001b[0m  │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOSEN : 1. Search for a drink  \n");
                    new SearchMenu().secondMenu();
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Add/remove recipe  \n");
                    break;
                case 3:
                    STDOUT.info(" CHOSEN : 3. Manage yours favorites \n");
                    break;
                case 4:
                    STDOUT.info(" CHOSEN : 4. Edit configuration      \n");
                    new PropertiesMenu().propertiesMenu();
                    break;
                case 5:
                    mainExitCode = 5;
                    STDOUT.info("\n");
                    STDOUT.info("┌──────────────────────────────────────────┐\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("│       \u001b[35m       SEE YOU LATER!      \u001b[0m        │\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("└──────────────────────────────────────────┘\n");
                    STDOUT.info("\n");
                    System.exit(0);
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