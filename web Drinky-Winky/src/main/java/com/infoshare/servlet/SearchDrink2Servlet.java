package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
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
import java.util.Map;

@WebServlet("/search-drink2")
public class SearchDrink2Servlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;

    @Inject
    SearchEngineUtils searchEngineUtils;

    @Inject
    DrinkService drinkService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String drinkSearch = request.getParameter("drinkSearch");

        int result1 = drinkService.findDrinkListByName(drinkSearch).size();
        int result2 = drinkService.findDrinkListByCategory(drinkSearch).size();
        int result3 = drinkService.findDrinkListByGlass(drinkSearch).size();
        int result4 = drinkService.findDrinkListByIngredient(drinkSearch).size();
        int result5 = drinkService.findDrinkListByType(drinkSearch).size();

        Map<String, Object> root = new HashMap<>();
        root.put("names", drinkService.findDrinkListByName(drinkSearch));
        root.put("categories", drinkService.findDrinkListByCategory(drinkSearch));
        root.put("glassTypes", drinkService.findDrinkListByGlass(drinkSearch));
        root.put("ingredients", drinkService.findDrinkListByIngredient(drinkSearch));
        root.put("types", drinkService.findDrinkListByType(drinkSearch));

        root.put("result1", result1);
        root.put("result2", result2);
        root.put("result3", result3);
        root.put("result4", result4);
        root.put("result5", result5);

        Template template = templateProvider.getTemplate(getServletContext(), "drink-search2.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
