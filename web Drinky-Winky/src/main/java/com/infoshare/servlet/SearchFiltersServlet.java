package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.model.Drink;
import com.infoshare.service.CategoryService;
import com.infoshare.service.DrinkService;
import com.infoshare.utils.SearchEngineUtils;
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
import java.util.List;
import java.util.Map;

@WebServlet("/filters")
public class SearchFiltersServlet extends HttpServlet {


    @Inject
    TemplateProvider templateProvider;
    @Inject
    DrinkService drinkService;
    @Inject
    CategoryService categoryService;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String drinkType = request.getParameter("drinkType");
        String glassType = request.getParameter("glassType");

        Map<String, Object> root = new HashMap<>();
        root.put("names", drinkService.getDrinkList());
        root.put("categories", categoryService.getCategoriesList());
        root.put("glasses", drinkService.getDrinkList());

        Template template = templateProvider.getTemplate(getServletContext(), "filters.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
