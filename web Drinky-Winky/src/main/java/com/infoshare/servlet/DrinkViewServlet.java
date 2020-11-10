package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.freemarker.TemplateProvider;
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
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Drink-view")
public class DrinkViewServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    DrinkService drinkService;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DrinkDTO drink = drinkService.getDrinkByName(request.getParameter("name"));

        Map<String, Object> root = new HashMap<>();
        root.put("drink", drink);
        root.put("ingredients",drink.getIngredientList());
        root.put("user",request.getRemoteUser());
        root.put("allDrink", drinkService.getDrinkList());

        Template template = templateProvider.getTemplate(getServletContext(), "drink-view.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
