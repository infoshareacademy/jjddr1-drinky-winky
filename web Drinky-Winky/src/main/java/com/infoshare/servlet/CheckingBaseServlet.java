package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.model.Category;
import com.infoshare.model.Drink;
import com.infoshare.model.Ingredient;
import com.infoshare.service.CategoryService;
import com.infoshare.service.DrinkService;
import com.infoshare.service.IngredientService;
import com.infoshare.service.StartingPageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/Drinks")
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

        String[] allCheckedCategoriesList = categoryService.getCategoryIds();

        List<String> pageNumber = Arrays.asList(getParamterersList(request, "page", new String[]{"1"}));
        List<String> checkedCategoriesList = Arrays.asList(getParamterersList(request, "categories[]", allCheckedCategoriesList));
        List<String> checkedIngredientsList = Arrays.asList(getParamterersList(request, "ingredients[]", new String[]{}));

        Integer pageNo = Integer.parseInt(pageNumber.get(0));
        List<Drink> drinkList = startingPageService.getDrinksPerPage(pageNo, drinkService.getDrinkList());
        List<Category> categoriesList = categoryService.getCategoriesList();

        List<Ingredient> ingredientList = ingredientService.getIngredientsList();
        List<Long> paredToLongCategoriesList = checkedCategoriesList.stream().map(s -> Long.parseLong(s)).collect(Collectors.toList());
        List<Drink> checkedCategoriesAndIngredient;
        if (checkedIngredientsList.size() == 0 || checkedIngredientsList == null || checkedIngredientsList.isEmpty()) {
            checkedCategoriesAndIngredient = drinkService.findRecipeByCategoryId(paredToLongCategoriesList);
        } else {
            checkedCategoriesAndIngredient = drinkService.findDrinkByCategoryIdAndIngredient(paredToLongCategoriesList, checkedIngredientsList);
        }

        List<Drink> drinkListPerPage = startingPageService.getDrinksPerPage(pageNo, checkedCategoriesAndIngredient);
        Integer lastPageNumber = startingPageService.getLastNumberPage(checkedCategoriesAndIngredient);

        Template template = templateProvider.getTemplate((getServletContext()), "test.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (drinkList != null || drinkList.isEmpty() || categoriesList != null || categoriesList.isEmpty() || checkedCategoriesAndIngredient != null || checkedCategoriesAndIngredient.isEmpty()) {
            model.put("drinks", drinkListPerPage);
            model.put("pageNumber", pageNo);
            model.put("lastPageNumber", lastPageNumber);
            model.put("categoryList", categoriesList);
            model.put("categoryListChecked", checkedCategoriesList);
            model.put("ingredientList", ingredientList);
            model.put("ingredientListChecked", checkedIngredientsList);
        }
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }
    }
        public static String[] getParamterersList(ServletRequest request, String paramName, String[] defaultValue) {
            if (request.getParameterValues(paramName) != null) {
                return request.getParameterValues(paramName);
            } else {
                return defaultValue;
            }
        }
}