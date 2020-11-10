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

@WebServlet("/search-drink")
public class SearchDrinkServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    SearchEngineUtils searchEngineUtils;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String drinkSearch = request.getParameter("drinkSearch");

        Map<String, Object> root = new HashMap<>();
        root.put("names", searchEngineUtils.findDrinkByAll(drinkSearch));

        Template template = templateProvider.getTemplate(getServletContext(), "/search-engine/drink-search.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

/*    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> root = new HashMap<>();
        root.put("names", drinkService.getDrinkList());

        String drinkSearch = request.getParameter("drinkSearch");

        List<DrinkDTO> recipesList = drinkService.getDrinkByFirstTreeChars(drinkSearch);


        for(DrinkDTO drink:recipesList){
            root.put("ing",drink.getIngredientList());
        }

        Template template = templateProvider.getTemplate(getServletContext(), "view.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }*/




