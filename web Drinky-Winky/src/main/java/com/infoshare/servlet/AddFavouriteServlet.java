package com.infoshare.servlet;

import com.infoshare.service.DrinkService;
import com.infoshare.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Add-favourite")
public class AddFavouriteServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;
    @Inject
    UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("login");
        Long id = userService.findUserByLogin(login).orElseThrow().getId();

        String name = request.getParameter("name");
        Long drinkId = drinkService.getDrinkByName(name).getId();
        userService.saveFavDrink(drinkId, id);

        response.sendRedirect("Drink-view?name=" + name);
    }
}
