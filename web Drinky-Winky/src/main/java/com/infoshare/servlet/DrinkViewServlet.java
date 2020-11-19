package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.model.Drink;
import com.infoshare.service.DrinkService;
import com.infoshare.service.MessageService;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/Drink-view")
public class DrinkViewServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    DrinkService drinkService;
    @Inject
    UserService userService;
    @Inject
    MessageService messageService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        String login = (String) session.getAttribute("login");
        Long id = userService.findUserByLogin(login).orElseThrow().getId();

        DrinkDTO drink = drinkService.getDrinkByName(request.getParameter("name"));

        Map<String, Object> root = new HashMap<>();
        root.put("drink", drink);
        root.put("ingredients",drink.getIngredientList());
        root.put("user",request.getRemoteUser());
        root.put("allDrink", drinkService.getDrinkList());
        root.put("favourite", userService.isFavourite(drink.getName(), id));

        if (messageService.getMessageById(1L).isPresent()) {
            root.put("message", messageService.getMessageById(1L).orElseThrow());
            messageService.clean(1L);
        }

        Template template = templateProvider.getTemplate(getServletContext(), "drink-view.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
