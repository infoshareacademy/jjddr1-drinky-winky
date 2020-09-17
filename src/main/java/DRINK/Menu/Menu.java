package DRINK.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Menu {

    public static final Scanner scanner = new Scanner(System.in);
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void mainMenu() {
        int mainExitCode = 0;

        stdout.info("┌──────────────────────────────────────────┐\n");
        stdout.info("│                                          │\n");
        stdout.info("│ \u001b[32m   WELCOME TO MANAGE DRINK APLICATION    \u001b[0m│\n");
        stdout.info("│                                          │\n");
        stdout.info("│           (c) Drinky-Winky               │\n");
        stdout.info("│                                          │\n");
        stdout.info("└──────────────────────────────────────────┘\n");
        stdout.info("\n");
        stdout.info("\n");

        while (mainExitCode != 9) {

            stdout.info("┌──────────────────────────────────────────┐\n");
            stdout.info("│    \u001b[35m    CHOOSE OPTION FROM MENU         \u001b[0m  │\n");
            stdout.info("│                                          │\n");
            stdout.info("│   1. List of all recipes                 │\n");
            stdout.info("│   2. Search for specific recipe          │\n");
            stdout.info("│   3. Add/remove recipe                   │\n");
            stdout.info("│   4. Manage yours favorites              │\n");
            stdout.info("│   5. Search for drink by category        │\n");
            stdout.info("│   6. Edit configuration                  │\n");
            stdout.info("│                                          │\n");
            stdout.info("│  \u001b[36m 9. END OF PROGRAM                    \u001b[0m  │\n");
            stdout.info("└──────────────────────────────────────────┘\n");
            stdout.info("\n");
            stdout.info("CHOOSE NUMBER: \n");

            switch (Choicemenu.choiceMenu()) {
                case 1:
                    stdout.info(" CHOSEN : 1. List of all recipes   \n");
                    new DRINK.Menu.ShowByCategory().showByCategory();
                    //TODO PRINT ALL EVENTS
                    break;
                case 2:
                    stdout.info(" CHOSEN : 2. Search for specific recipe\n");
                    new DRINK.Menu.ShowByCategory().showByCategory();
                    //TODO metoda 2
                    break;
                case 3:
                    //TODO metoda 3
                    stdout.info(" CHOSEN : 3. Add/remove recipe  \n");
                    new DRINK.Menu.ShowByCategory().showByCategory();
                    break;
                case 4:
                    //TODO metoda 3
                    stdout.info(" CHOSEN : 4. Manage yours favorites \n");
                    new DRINK.Menu.ShowByCategory().showByCategory();
                    break;
                case 5:
                    //TODO metoda 3
                    stdout.info(" CHOSEN : 5. Search for drink by category\n");
                    new DRINK.Menu.ShowByCategory().showByCategory();
                    break;
                case 6:
                    //TODO metoda 3
                    stdout.info(" CHOSEN : 6. Edit configuration      \n");
                    new DRINK.Menu.ShowByCategory().showByCategory();
                    break;
                case 9:
                    stdout.info("\n");
                    stdout.info("┌──────────────────────────────────────────┐\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│       \u001b[35m       SEE YOU LATER!      \u001b[0m        │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("└──────────────────────────────────────────┘\n");
                    stdout.info("\n");
                    mainExitCode = 9;
                    break;
                case 0:
                    break;
                default:
                    stdout.info("\n");
                    stdout.info("┌──────────────────────────────────────────┐\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│       \u001b[31mYOU HAVE ENTERED WRONG NUMBER! \u001b[0m    │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("│               TRY AGAIN!                 │\n");
                    stdout.info("│                                          │\n");
                    stdout.info("└──────────────────────────────────────────┘\n");
                    stdout.info("\n");
            }
        }
    }
}