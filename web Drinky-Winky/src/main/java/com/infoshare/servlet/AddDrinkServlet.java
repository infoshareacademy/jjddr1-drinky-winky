package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import com.infoshare.service.DrinkService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addDrink")
public class AddDrinkServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setDrinkName(request.getParameter("drinkName"));
        drinkDTO.setGlass(request.getParameter("glass"));

        DrinkService drinkService = new DrinkService();
        drinkService.saveDrink(drinkDTO);

//        drinkDTO = drinkService.findById(drinkDTO.getId());

        PrintWriter printWriter = response.getWriter();
        printWriter.write("<!DOCTYPE html><html><body>" + drinkDTO + "</body></html> ");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("drinkName", "TwojaStara");
        RequestDispatcher rd = request.getRequestDispatcher("addDrink.jsp");
        rd.forward(request, response);
    }
}
