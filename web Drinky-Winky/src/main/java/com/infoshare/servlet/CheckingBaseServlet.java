package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.service.CategoryService;
import com.infoshare.service.DrinkService;
import com.infoshare.service.IngredientService;
import com.infoshare.service.StartingPageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/drinks")
public class CheckingBaseServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CheckingBaseServlet.class.getName());
    @Inject
    TemplateProvider templateProvider;
    @Inject
    CategoryService categoryService;
    @Inject
    DrinkService drinkService;
    @Inject
    IngredientService ingredientService;
    @Inject
    StartingPageService startingPageService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String pageNumber = Optional.ofNullable(request.getParameter("page")).orElse("1");

        List<String> checkedCategoriesList = Optional.ofNullable(Arrays.asList(request.getParameterValues("categories[]"))).orElse(Arrays.asList("-1"));
        List<String> checkedIngredientsList = Optional.ofNullable(Arrays.asList(request.getParameterValues("ingredients[]"))).orElse(Arrays.asList("emptyString"));
        List<String> checkedListOptions = Optional.ofNullable(Arrays.asList(request.getParameterValues("listOptions[]"))).orElse(Arrays.asList("emptyString"));

        Integer pageNo = Integer.parseInt(pageNumber);
        List<Drink> drinkList = startingPageService.getDrinksPerPage(pageNo);
        List<Drink> allDrinks = startingPageService.getDrinkByFilterOption(checkedListOptions.get(0));
        List<Category> categoriesList = categoryService.getCategoriesList();
        Integer lastPageNumber = startingPageService.getLastNumberPage(allDrinks);
        List<String> ingredientList = ingredientService.getIngredientsList();
        List<Long> paredToLongCategoriesList = checkedCategoriesList.stream().map(s -> Long.parseLong(s)).collect(Collectors.toList());
        List<String> checkedCategoriesAndIngredient = drinkService.findDrinkByCategoryIdAndIngredient(paredToLongCategoriesList, checkedIngredientsList);


    }
}