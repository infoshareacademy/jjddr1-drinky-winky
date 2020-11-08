package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.CategoryService;
import com.infoshare.service.DrinkService;
import com.infoshare.service.IngredientService;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> root = new HashMap<>();
        root.put("drinks", drinkService.getDrinkList());
        root.put("categories", categoryService.getCategoriesList());
        root.put("glasses", drinkService.getUniqueGlassesNameList());
        root.put("ingredients",ingredientService.getUniqueIngredientsNameList());


        Template template = templateProvider.getTemplate(getServletContext(), "admin.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
