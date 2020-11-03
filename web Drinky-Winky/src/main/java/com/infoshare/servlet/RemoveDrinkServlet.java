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

        String name = request.getParameter("name");

        drinkService.deleteDrinkByName(name);

        response.sendRedirect("Admin");
    }
}
