//package com.infoshare.servlet;
//
//import com.infoshare.dto.DrinkDTO;
//import com.infoshare.model.Drink;
//import com.infoshare.service.DrinkService;
//
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//
//@WebServlet("/servlet")
//public class Servlet extends HttpServlet {
//
//    @Inject
//    DrinkService drinkService;
//    @Inject
//    Drink drink;
//    private String url = null;
//    private static Connection conn = null;
//    private static Connection get;
//
//    Connection Connection() {
//        try {
//            conn = DriverManager.getConnection("0.0.0.0:3307/contacts");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return conn;
//    }
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        DrinkDTO drinkDTO = new DrinkDTO();
////        PrintWriter printWriter = resp.getWriter();
////        printWriter.println(String.format("Drink saved: %s",drinkDTO.toString()));
////    }
//
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        DrinkDTO drinkDTO = new DrinkDTO();
//        drinkDTO.setId(Long.valueOf("1"));
//        drinkDTO.setDrinkName("voda");
//        drinkDTO.setCategoryName("Generally not a drink");
//        drinkDTO.setGlass("glass");
//        drinkDTO.setRecipeName("Recipe jest okej");
//        drinkDTO.setIsAlcoholic("yes");
//        drinkDTO.setDateModified("2020-10-23T15:43:00");
//        drinkDTO.setIngredientName("jakis ingredient");
//        drinkDTO.setIngredients(new ArrayList<>());
//
//
//        DrinkDTO drinkDTO1 = drinkService.saveDrink(drinkDTO);
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println(String.format("Person saved: %s", drinkDTO.toString()));






