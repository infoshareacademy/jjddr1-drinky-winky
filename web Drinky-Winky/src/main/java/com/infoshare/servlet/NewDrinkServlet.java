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

@WebServlet("/NewDrinkServlet")
public class NewDrinkServlet extends HttpServlet {

    @Inject
    DrinkService drinkService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        Boolean isCustom = true;
        Boolean isApproved = true;
        String recipe = request.getParameter("recipe");
        String drinkType = request.getParameter("drinkType");
        String glassType = request.getParameter("glassType");
        String modificationDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).toString();
        String imageUrl = request.getParameter("imageUrl");
        String category = request.getParameter("category");
        String ingredient = request.getParameter("ingredient");
        String measure = request.getParameter("measure");

        Category category1 = new Category();
        category1.setName(category);

        List<Ingredient> ingredient1 = new ArrayList<>();
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName(ingredient);
        ingredient2.setMeasure(measure);
        ingredient1.add(ingredient2);

        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setName(name);
        drinkDTO.setCustom(isCustom);
        drinkDTO.setApproved(isApproved);
        drinkDTO.setRecipe(recipe);
        drinkDTO.setDrinkType(drinkType);
        drinkDTO.setGlassType(glassType);
        drinkDTO.setModificationDate(modificationDate);
        drinkDTO.setImageUrl(imageUrl);
        drinkDTO.setCategory(category1);
        drinkDTO.setIngredientList(ingredient1);

        drinkService.addDrink(drinkDTO);
    }
}
