package DRINK.Menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import static DRINK.Menu.Menu.scanner;

public class Choicemenu {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int choiceMenu() {
        int result = 0;

        try {
            String in = scanner.next();

            if ((Pattern.matches("[0-9]", in))) {
                try {
                    result = Integer.parseInt(in);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}