package com.infoshare.drinkywinky.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import static com.infoshare.drinkywinky.menu.Menu.scanner;

public class ChoiceMenu {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static int choiceMenu() {
        int result = 0;

        try {
            String in = scanner.next();

            if ((Pattern.matches("[1-7]", in))) {
                try {
                    result = Integer.parseInt(in);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}