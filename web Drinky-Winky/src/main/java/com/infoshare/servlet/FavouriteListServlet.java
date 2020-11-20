package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.CategoryService;
import com.infoshare.service.DrinkService;
import com.infoshare.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/Favourite-list")
public class FavouriteListServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    UserService userService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, Object> root = new HashMap<>();

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(5 * 60);
        String login = (String) session.getAttribute("login");
        Long id = userService.findUserByLogin(login).orElseThrow().getId();

        List<DrinkDTO> favouriteList = userService.getFavouriteList(id);

        if (login == null) {
            response.sendRedirect("Logout");
        }

        int size = userService.getFavouriteList(id).size();
        int numberOfPage = 1;
        List<Integer> pages = new ArrayList<>();

        if (size != 0) {
            if (size % 8 == 0) {
                numberOfPage = size / 8;
            } else {
                numberOfPage = size / 8 + 1;
            }
        }

        for (int pageNumber = 1; pageNumber <= numberOfPage; pageNumber++) {
            pages.add(pageNumber);
        }

        String page = request.getParameter("page");
        if (page.equals("user")) {
            root.put("drinkList", userService.getRequestFavouriteDrinkList(id, numberOfPage, 8));
        } else {
            int i = Integer.parseInt(page);
            root.put("drinkList", userService.getRequestFavouriteDrinkList(id, i, 8));
            root.put("pageNumber", pages);
        }

        String loggedUser = userService.findUserByLogin(login).orElseThrow().getName();
        root.put("loggedUser", loggedUser);

        Template template = templateProvider.getTemplate(getServletContext(), "Favourite-view.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
