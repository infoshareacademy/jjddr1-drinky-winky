package com.infoshare.servlet;

import com.infoshare.service.DrinkService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Remove-drink")
public class RemoveDrinkServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        String name = request.getParameter("name");

        drinkService.deleteDrinkById(1l);
        drinkService.deleteDrinkById(5l);
        drinkService.deleteDrinkById(10l);
        drinkService.deleteDrinkById(15l);
        drinkService.deleteDrinkById(20l);

//        drinkService.deleteRecipeById(drinkService
//                .getRecipesList()
//                .stream()
//                .filter(drink ->
//                        drink.getName()
//                                .equals(name))
//                .collect(Collectors.toList())
//                .get(0).getId());

        response.sendRedirect("Admin");
    }
}
