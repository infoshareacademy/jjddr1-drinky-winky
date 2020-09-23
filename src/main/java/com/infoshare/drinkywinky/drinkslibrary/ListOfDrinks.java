package com.infoshare.drinkywinky.drinkslibrary;

import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOfDrinks {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public void alphabeticalMenu() {
        List<String> defaultList = Utils.getNamesOfAllDrink();
        List<String> alphabeticalList = defaultList.stream().sorted().collect(Collectors.toList());

    }

    public void changePage() {

    }

    public static void main(String[] args) {

    }
}
