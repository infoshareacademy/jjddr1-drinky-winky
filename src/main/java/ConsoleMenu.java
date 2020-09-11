import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsoleMenu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice = -1;
        printMenu();
        choice = scan.nextInt();
        while (choice != 7) {
            switch (choice) {
                case 1:
                    STDOUT.info("You have choose option 1.\n");
                    break;
                case 2:
                    STDOUT.info("You have choose option 2.\n");
                    //findByName();
                    break;
                case 3:
                    STDOUT.info("You have choose option 3.\n");
                    break;
                case 4:
                    STDOUT.info("You have choose option 4.\n");
                    break;
                case 5:
                    STDOUT.info("You have choose option 5.\n");
                    break;
                case 6:
                    STDOUT.info("You have choose option 6.\n");
                    break;
                case 7:
                    STDOUT.info("You have choose option 7.\n");
                    break;
                default:
                    STDOUT.info("There is no such option.\n");
                    break;
            }

        printMenu();
        choice = scan.nextInt();
        }
        STDOUT.info("Thank you for using our program\n");
    }

    public static void printMenu() {
        STDOUT.info("Welcome to out DRINKY-WINKIE drinks book application!!!" +
                "\n" + "Lets try to find drink what will suit you !\n" + "Please take a look on menu :\n"+
                "1. List of all recipes.\n" +
                "2. Search recipe.\n" +
                "3. Add/remove recipe." +
                "\n4. Add/remove recipe from favoritues." +
                "\n5. Search by the cathegory.\n" +
                "6. Edit configuration.\n" +
                "7. EXIT.\n");
    }
}


