package com.infoshare.servlet;

import com.infoshare.dto.UserDTO;
import com.infoshare.model.User;
import com.infoshare.service.LoggingService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/logpage")
public class LoggingTestServlet extends HttpServlet {

    @Inject
    LoggingService loggingService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("logging.jsp");
        rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();

        if (loggingService.checkIfUserExist(login).isPresent()) {
            UserDTO registeredUserDTO = loggingService.checkIfUserExist(login).get();

            if (loggingService.checkCorrectPassword(registeredUserDTO, password)) {
                request.getSession().setAttribute("login", registeredUserDTO.getLogin());
                request.getSession().setAttribute("password", registeredUserDTO.getPassword());

                printWriter.write("<!DOCTYPE html><html><body>You're logged in</br>" + registeredUserDTO.getLogin() + " " + registeredUserDTO.getPassword() + "</body></html>");
            } else {
                printWriter.write("<!DOCTYPE html><html><body>Write correct password</body></html>");
            }
        } else {
            printWriter.write("<!DOCTYPE html><html><body>User with that login doesn't exist. Please register!</body></html>");
        }
    }
}
