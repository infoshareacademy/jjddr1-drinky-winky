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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String typeOfUser = request.getParameter("userType");

        UserDTO userLog = userService.getUserLogin(login);
        UserDTO userPass = userService.getUserPassword(password);
        UserDTO userType = userService.getUserType(typeOfUser);

        if (userLog != null && userPass != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login", login);
            session.setAttribute("userType", typeOfUser);
            response.sendRedirect("User-view?page=1");

        } else {
            response.sendRedirect("Login");
        }
    }
}
