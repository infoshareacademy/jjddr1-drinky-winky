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
        String name = req.getParameter("drinkName");
        DrinkDTO drinkDTO = new DrinkDTO();
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(String.format("Drink saved: %s",drinkDTO.toString()));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}





