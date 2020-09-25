package com.infoshare.drinkywinky.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowByCategory {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    void showByCategory() {
        int submenu2ExitCode = 0;

        while (submenu2ExitCode != 7) {
            STDOUT.info("\n");
            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[33m CHOOSE OPTION      \u001b[0m                    │\n");
            STDOUT.info("│           \u001b[33m \u001b[0m                              │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. SHOW  ....                          │\n");
            STDOUT.info("│   2. SHOW  .....                         │\n");
            STDOUT.info("│   3. SHOW  ........                      │\n");
            STDOUT.info("│   4. SHOW  ..........                    │\n");
            STDOUT.info("│  \u001b[36m 7. BACK TO MAIN MENU\u001b[0m                   │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info("\nOPTION SUBMENU 2 - 1\n");
                    break;
                case 2:
                    //TODO metoda2
                    STDOUT.info("\nOPTION SUBMENU 2 - 2\n");
                    break;
                case 7:
                    //TODO metoda 3
                    STDOUT.info("       BACK TO MAIN MENU       \n\n");
                    submenu2ExitCode = 7;
                    break;
                case 0:
                    break;
                default:
                    //TODO metoda 1
                    STDOUT.info("\n");
                    STDOUT.info("┌──────────────────────────────────────────┐\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("│       \u001b[31mYOU HAVE ENTERED WRONG BUTTON! \u001b[0m    │\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("│               TRY AGAIN!                 │\n");
                    STDOUT.info("│                                          │\n");
                    STDOUT.info("└──────────────────────────────────────────┘\n");
                    STDOUT.info("\n");
            }
        }
    }
}