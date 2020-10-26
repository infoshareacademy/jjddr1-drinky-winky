package com.infoshare.servlet;

import com.infoshare.model.Drink;
import com.infoshare.service.DrinkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FindDrinkById")
public class FindDrinkByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestParameter = request.getParameter("id");
        Long id = Long.valueOf(requestParameter);
        DrinkService drinkService = new DrinkService();
        Drink foundDrink = drinkService.findById(id);

        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        if (requestParameter == null || requestParameter.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (foundDrink != null) {
            printWriter.println("<!DOCTYPE html><html><body>ID:" + foundDrink + "\nname:" + foundDrink.getDrinkName() + "</body></html> ");
        } else{
            printWriter.println("Drink has not been found");
        }
    }
}
