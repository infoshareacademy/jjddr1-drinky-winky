import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {


        ConsoleMenu consoleMenu = new ConsoleMenu();
        STDOUT.info("hello my friend");
        System.out.println("Test");


    }
}

