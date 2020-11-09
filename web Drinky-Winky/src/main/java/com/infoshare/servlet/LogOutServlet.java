package com.infoshare.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class LogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession() != null){
            request.getSession().invalidate();
            response.sendRedirect("Start");
        }

        //        Cookie cookie = new Cookie ("userName", "");
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
    }
}