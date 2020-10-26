package com.infoshare.servlet;

import com.infoshare.dto.DrinkDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("drinkName");
//        DrinkDTO drinkDTO = new DrinkDTO();
//        drinkDTO.setDrinkName("voda");
//        drinkDTO.setCategoryName("Oridin");
//        drinkDTO.setGlass("glass");
//
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println(String.format("Drink saved: %s",drinkDTO.toString()));


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("drinkName");
//        DrinkDTO drinkDTO = new DrinkDTO();
//        drinkDTO.setDrinkName("voda");
//        drinkDTO.setCategoryName("Oridin");
//        drinkDTO.setGlass("glass");
//
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html><html><body>Weclome to Miami!</body></html> ");

    }
}





