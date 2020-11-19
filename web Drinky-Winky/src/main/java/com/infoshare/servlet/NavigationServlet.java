package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Navigation-servlet")
public class NavigationServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("navigator").equals("Login")) {
            response.sendRedirect("Login");

        } else if (request.getParameter("navigator").equals("Register")) {
            response.sendRedirect("Register");
        }
    }
}
