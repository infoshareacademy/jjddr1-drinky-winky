package com.infoshare.servlet;

import com.infoshare.service.DrinkService;
import com.infoshare.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Add-favourite")
public class AddFavouriteServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;
    @Inject
    UserService userService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");

        Long drinkId = drinkService.getDrinkByName(name).getId();

        userService.saveFavDrink(drinkId, 1L);

        response.sendRedirect("User-view");
    }
}
