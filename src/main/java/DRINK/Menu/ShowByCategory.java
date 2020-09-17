package DRINK.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowByCategory {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void showByCategory() {
        int submenu2ExitCode = 0;

        while (submenu2ExitCode != 9) {
            stdout.info("\n");
            stdout.info("┌──────────────────────────────────────────┐\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[33m CHOOSE OPTION      \u001b[0m                    │\n");
            stdout.info("│           \u001b[33m \u001b[0m                              │\n");
            stdout.info("│                                          │\n");
            stdout.info("│   1. SHOW  ....                          │\n");
            stdout.info("│   2. SHOW  .....                         │\n");
            stdout.info("│   2. SHOW  ........                      │\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[36m 9. BACK TO MAIN MENU\u001b[0m                   │\n");
            stdout.info("│                                          │\n");
            stdout.info("└──────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("CHOOSE NUMBER: \n");

            switch (Choicemenu.choiceMenu()) {
                case 1:
                    stdout.info("\nOPTION SUBMENU 2 - 1\n");
                    break;
                case 2:
                    //TODO metoda2
                    stdout.info("\nOPTION SUBMENU 2 - 2\n");
                    break;
                case 9:
                    //TODO metoda 3
                    stdout.info("       BACK TO MAIN MENU       \n\n");
                    submenu2ExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    //TODO metoda 1
                    stdout.info("\n");
                    stdout.info("┌──────────────────────────────────────────┐\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│       \u001b[31mYOU HAVE ENTERED WRONG BUTTON! \u001b[0m    │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│               TRY AGAIN!                 │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("└──────────────────────────────────────────┘\n");
                    stdout.info("\n");
            }
        }
    }
}