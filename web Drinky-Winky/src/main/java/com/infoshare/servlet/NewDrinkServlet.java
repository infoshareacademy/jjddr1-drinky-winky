package com.infoshare.servlet;

import com.infoshare.service.DrinkService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/NewDrinkServlet")
public class NewDrinkServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        Boolean isCustom = true;
        Boolean isApproved = true;
        String recipe = request.getParameter("recipe");
        String drinkType = request.getParameter("drinkType");
        String glassType = request.getParameter("glassType");
        String modificationDate = LocalDate.now().toString();
        String imageUrl = request.getParameter("imageUrl");

        String category = request.getParameter("category");

        String ingredient = request.getParameter("ingredient");
        String measure = request.getParameter("measure");


    }
}
