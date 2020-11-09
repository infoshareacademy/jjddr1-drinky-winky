package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Drink;
import com.infoshare.service.DrinkService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/Test-database")
public class TestDatabaseServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DrinkDTO bora_bora = drinkService.getDrinkByName("Bora Bora");
        List<DrinkDTO> recipesList = drinkService.getDrinkList();
        DrinkDTO drinkById = drinkService.getDrinkById(4l);

        List<DrinkDTO> bijou = recipesList.stream().filter(drink -> drink.getName().equals("Bijou")).collect(Collectors.toList());
        DrinkDTO dryn = bijou.get(0);
        drinkService.deleteDrinkById(dryn.getId());


        PrintWriter printWriter = response.getWriter();
        printWriter.println(bora_bora);
        printWriter.println(recipesList);
        printWriter.println(drinkById);
    }
}
