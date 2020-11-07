package com.infoshare.servlet;

import com.infoshare.dao.UserDao;
import com.infoshare.dto.UserDTO;
import com.infoshare.model.User;
import com.infoshare.service.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/register")
public class RegisterTestServlet extends HttpServlet {

    @Inject
    UserDao userDao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setFavouriteDrinkList(new ArrayList<>());
        user.setUserType("User");


        userDao.saveUser(user);

        String userek =userDao.findUserByName(user.getName()).getName();

        PrintWriter printWriter = response.getWriter();
        printWriter.write("<!DOCTYPE html><html><body>" + userek + "</body></html>");

    }
}
