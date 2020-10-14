package com.infoshare.drinkywinky;

import com.infoshare.drinkywinky.menu.Menu;
import com.infoshare.drinkywinky.properties.ConfigLoader;

public class Main {

    public static void main(String[] args) {

        /*
         display main menu
        */
        new ConfigLoader().loadAppConfig();
        Menu.intro();
        Menu.mainMenu();
    }
}
