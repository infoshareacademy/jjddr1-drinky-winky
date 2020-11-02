package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.model.Category;
import com.infoshare.model.Ingredient;
import com.infoshare.service.DrinkDeserializer;
import com.infoshare.service.DrinkService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/New-drink")
public class NewDrinkServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String recipe = request.getParameter("recipe");
        String drinkType = request.getParameter("drinkType");
        String glassType = request.getParameter("glassType");
        String modificationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern(new DrinkDeserializer().getNewDatePattern()));
        String imageUrl = request.getParameter("imageUrl");
        String categoryName = request.getParameter("category");
        String[] ingredientName = request.getParameterValues("ingredient");
        String[] measureName = request.getParameterValues("measure");
        Category category = new Category();
        category.setName(categoryName);
        List<Ingredient> ingredientList = new ArrayList<>();

        for (int ing = 0; ing < ingredientName.length; ing++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientName[ing]);
            ingredient.setMeasure(measureName[ing]);
            ingredientList.add(ingredient);
        }

        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setName(name);
        drinkDTO.setCustom(true);
        drinkDTO.setApproved(true);
        drinkDTO.setRecipe(recipe);
        drinkDTO.setDrinkType(drinkType);
        drinkDTO.setGlassType(glassType);
        drinkDTO.setModificationDate(modificationDate);
        drinkDTO.setImageUrl(imageUrl);
        drinkDTO.setCategory(category);
        drinkDTO.setIngredientList(ingredientList);

        drinkService.addDrink(drinkDTO);
    }
}
