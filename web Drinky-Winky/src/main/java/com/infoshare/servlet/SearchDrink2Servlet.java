package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String drinkSearch = request.getParameter("drinkSearch");

        int result1 = searchEngineUtils.findDrinkByName(drinkSearch).size();
        int result2 = searchEngineUtils.findDrinkByCategory(drinkSearch).size();
        int result3 = searchEngineUtils.findDrinkByGlass(drinkSearch).size();
        int result4 = searchEngineUtils.findDrinkByIngredient(drinkSearch).size();
        int result5 = searchEngineUtils.findDrinkByType(drinkSearch).size();

        Map<String, Object> root = new HashMap<>();
        root.put("names", searchEngineUtils.findDrinkByName(drinkSearch));
        root.put("categories", searchEngineUtils.findDrinkByCategory(drinkSearch));
        root.put("glassTypes", searchEngineUtils.findDrinkByGlass(drinkSearch));
        root.put("ingredients", searchEngineUtils.findDrinkByIngredient(drinkSearch));
        root.put("types", searchEngineUtils.findDrinkByType(drinkSearch));

        root.put("result1", result1);
        root.put("result2", result2);
        root.put("result3", result3);
        root.put("result4", result4);
        root.put("result5", result5);

        Template template = templateProvider.getTemplate(getServletContext(), "/search-engine/drink-search2.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
