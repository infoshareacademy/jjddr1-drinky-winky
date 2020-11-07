package com.infoshare.service;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;



@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private static final Long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "pass";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        if(userID.equals(user) && password.equals(pass)){
            HttpSession session = req.getSession();
            session.setAttribute("user", "admin");

            Cookie loginCookie = new Cookie("email", user);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            resp.addCookie(loginCookie);
            resp.sendRedirect("User-view");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("Login");
            rd.include(req,resp);
        }

    }
}
