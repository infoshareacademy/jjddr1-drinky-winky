package com.infoshare.servlet;

import com.infoshare.model.Drink;
import com.infoshare.service.DrinkService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NewDrinkServlet")
public class NewDrinkServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String alcohol = request.getParameter("alcohol");
        String category = request.getParameter("category");
        String glass = request.getParameter("glass");
        String name = request.getParameter("name");
        String recipe = request.getParameter("recipe");


        Drink drink = new Drink(name, recipe, alcohol, glass);
        drinkService.editDrink(drink);


    }
}
