package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.properties.AppConfig;
import com.infoshare.drinkywinky.properties.ConfigLoader;
import com.infoshare.drinkywinky.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

import static com.infoshare.drinkywinky.menu.Menu.WrongNumber;
import static com.infoshare.drinkywinky.properties.AppConfig.dateFormat;
import static com.infoshare.drinkywinky.properties.AppConfig.recipeSortType;

public class PropertiesMenu {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static Object SORT_TYPE = AppConfig.recipeSortType;
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final String CONFIG_PATH = "src/main/resources/config.properties";
    private static final String MESSAGE = "File saved!";

    public static void decision() {
        STDOUT.info("Are you sure to reset data base ?\n");
        String answer = SCANNER.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            Repository.loadDataBase();
            STDOUT.info("FILE RESTORED.\n");
            STDOUT.info("PLEASE WAIT RESTARTING PROGRAM TO GET UPDATED.\n");
        } else {
            STDOUT.info("Returning to properties menu.\n");
            propertiesMenu();
        }
    }

    public static void propertiesMenu() {
        Properties prop = new Properties();
        ConfigLoader config = new ConfigLoader();
        int mainExitCode = 0;

        while (mainExitCode != 4) {
            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[107m      CHOOSE OPTION FROM MENU       \u001b[0m    │\n");
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
                                prop.get(ConfigLoader.DATE_FORMAT_KEY);
                                prop.get(ConfigLoader.RECIPE_SORT_TYPE_KEY);
                                OutputStream out = new FileOutputStream(CONFIG_PATH);
                                prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "ASC");
                                prop.put(ConfigLoader.DATE_FORMAT_KEY, dateFormat);
                                prop.store(out, MESSAGE);
                                config.loadAppConfig();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            STDOUT.info("DESC activated\n");
                            try {
                                prop.get(ConfigLoader.DATE_FORMAT_KEY);
                                prop.get(ConfigLoader.RECIPE_SORT_TYPE_KEY);
                                OutputStream out = new FileOutputStream(CONFIG_PATH);
                                prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "DESC");
                                prop.put(ConfigLoader.DATE_FORMAT_KEY, dateFormat);
                                prop.store(out, MESSAGE);
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
                        if (recipeSortType.equals("DESC")) {
                            prop.get(ConfigLoader.DATE_FORMAT_KEY);
                            prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "DESC");
                            Menu.SCANNER.nextLine();
                            OutputStream out = new FileOutputStream(CONFIG_PATH);
                            prop.put(ConfigLoader.DATE_FORMAT_KEY, Menu.SCANNER.nextLine());
                            prop.store(out, MESSAGE);
                            config.loadAppConfig();
                            STDOUT.info("Chosen: {} \n", dateFormat);
                            break;
                        }
                        if (recipeSortType.equals("ASC")) {
                            prop.get(ConfigLoader.DATE_FORMAT_KEY);
                            prop.setProperty(ConfigLoader.RECIPE_SORT_TYPE_KEY, "ASC");
                            Menu.SCANNER.nextLine();
                            OutputStream out = new FileOutputStream(CONFIG_PATH);
                            prop.put(ConfigLoader.DATE_FORMAT_KEY, Menu.SCANNER.nextLine());
                            prop.store(out, MESSAGE);
                            config.loadAppConfig();
                            STDOUT.info("Chosen: {} \n", dateFormat);
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
                    WrongNumber();
                    break;
            }
        }
    }
}