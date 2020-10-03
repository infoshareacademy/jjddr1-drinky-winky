package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.properties.AppConfig;
import com.infoshare.drinkywinky.properties.ConfigLoader;
import com.infoshare.drinkywinky.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.infoshare.drinkywinky.menu.Menu.SCANNER;

public class PropertiesMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void decision() {
        STDOUT.info("Are you sure to reset data base ?\n");
        String answer = SCANNER.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            List<String> drink = new ArrayList<>();
            STDOUT.info("FILE RESTORED.\n");
            Repository.loadDataBase();
            STDOUT.info("PLEASE WAIT RESTARTING PROGRAM TO GET UPDATED.\n");
        } else {
            STDOUT.info("Returning to properties menu.\n");
            propertiesMenu();
        }
    }

    public static void propertiesMenu() {
        Properties prop = new Properties();
        ConfigLoader config = new ConfigLoader();
        Object SORT_TYPE = AppConfig.recipeSortType;
        int mainExitCode = 0;

        while (mainExitCode != 4) {
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
                    STDOUT.info("┌──────────────────────────────────────────┐\n");
                    STDOUT.info("│      \u001b[101m        CHOOSE :         \u001b[0m           │\n");
                    STDOUT.info("│    1. Sort by ASC                        │\n");
                    STDOUT.info("│    2. Sort by DESC                       │\n");
                    STDOUT.info("└──────────────────────────────────────────┘\n");
                    switch (ChoiceMenu.choiceMenu()) {
                        case 1:
                            STDOUT.info("ASC activated\n");
                            try {
                                OutputStream out = new FileOutputStream("./resources/config.properties");
                                prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "ASC");
                                prop.setProperty(ConfigLoader.DATE_FORMAT_KEY, "yyyy-MM-dd HH:mm:ss");
                                prop.store(out, "File Saved");
                                config.loadAppConfig();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            STDOUT.info("DESC activated\n");
                            try {
                                OutputStream out = new FileOutputStream("./resources/config.properties");
                                prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "DESC");
                                prop.setProperty(ConfigLoader.DATE_FORMAT_KEY, "yyyy-MM-dd HH:mm:ss");
                                prop.store(out, "File Saved");
                                config.loadAppConfig();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;
                case 2:
                    config.loadAppConfig();

                    try {
                        STDOUT.info(" CHOSEN : 2. Date Formatter  \n");
                        STDOUT.info(" Please enter new date format :\ndefault : date.format=yyyy-MM-dd HH:mm:ss\n");
                        Menu.SCANNER.nextLine();
                        do {
                            if (SORT_TYPE.equals("DESC")) {
                                prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "DESC");
                            }
                            if (SORT_TYPE.equals("ASC")) {
                                prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "ASC");
                            } else {
                                STDOUT.info("Wrong data format. Please use as per instruction.\nyyyy - years, MM - months, dd - days, HH - hours, mm - minutes, ss - seconds\n");
                                propertiesMenu();
                            }
                            OutputStream out = new FileOutputStream("./resources/config.properties");
                            prop.setProperty(ConfigLoader.DATE_FORMAT_KEY, Menu.SCANNER.nextLine());
                            prop.store(out, "File Saved");
                            config.loadAppConfig();
                            STDOUT.info(String.format("Chosen :%s\n", AppConfig.dateFormat));
                            break;
                        }while (true) ;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }break;
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