package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.CategoryService;
import com.infoshare.service.DrinkService;
import com.infoshare.service.IngredientService;
import com.infoshare.service.MessageService;
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

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    CategoryService categoryService;
    @Inject
    DrinkService drinkService;
    @Inject
    IngredientService ingredientService;
    @Inject
    MessageService messageService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(5 * 60);
        Object login = session.getAttribute("login");
        if (login == null) {
            response.sendRedirect("Logout");
        }

        Map<String, Object> root = new HashMap<>();
        root.put("drinks", drinkService.getDrinkList());
        root.put("categories", categoryService.getCategoriesList());
        root.put("glasses", drinkService.getUniqueGlassesNameList());
        root.put("ingredients", ingredientService.getUniqueIngredientsNameList());

        if (messageService.getMessageById(1L).isPresent()) {
            root.put("message", messageService.getMessageById(1L).orElseThrow());
            messageService.clean(1L);
        }

        Template template = templateProvider.getTemplate(getServletContext(), "admin.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
