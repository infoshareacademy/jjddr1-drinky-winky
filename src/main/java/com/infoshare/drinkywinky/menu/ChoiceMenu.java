package com.infoshare.drinkywinky.menu;

import java.util.regex.Pattern;

import static com.infoshare.drinkywinky.menu.Menu.SCANNER;

public class ChoiceMenu {

    public static int choiceMenu() {
        int result = 0;

        try {
            String in = SCANNER.next();

            if ((Pattern.matches("[1-5]", in))) {
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
