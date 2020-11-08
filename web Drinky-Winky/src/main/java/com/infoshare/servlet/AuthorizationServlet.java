package com.infoshare.servlet;

import com.infoshare.dto.UserDTO;
import com.infoshare.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Auth")
public class AuthorizationServlet extends HttpServlet {

    @Inject
    UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
//        UserDTO userById = userService.getUserById(1L);
        UserDTO userByLogPass = userService.getUserByLoginAndPass(login, password);

        if (userByLogPass != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login", login);
            //setting session to expiry in 10s
            session.setMaxInactiveInterval(10);
            Cookie userName = new Cookie("login", login);
            //setting session to expiry in 10s
            userName.setMaxAge(10);
            response.addCookie(userName);
            if (session != null) {
                response.sendRedirect("User-view");
            }
        } else {
            response.sendRedirect("Login");
        }
    }
}
