package com.infoshare.servlet;

import com.infoshare.dto.UserDTO;
import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.LoggingService;
import com.infoshare.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Auth")
public class AuthorizationServlet extends HttpServlet {

    @Inject
    LoggingService loggingService;

    @Inject
    TemplateProvider templateProvider;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userLog = request.getParameter("login");
        String userPass = request.getParameter("password");

        if (loggingService.checkIfUserExist(userLog).isPresent()) {
            UserDTO registeredUserDTO = loggingService.checkIfUserExist(userLog).get();
            if (loggingService.checkCorrectPassword(registeredUserDTO, userPass)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("login", userLog);
//                session.setAttribute("role", userLog);

                Writer out = response.getWriter();
                Map<String, Object> root = new HashMap<>();
                Template template = templateProvider.getTemplate(getServletContext(), "userSignedIn.ftlh");

                try {
                    template.process(root, out);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            } else response.sendRedirect("Login");
        } else {
            response.sendRedirect("Login");
        }
    }
}
//            Cookie userName = new Cookie("login", login);
//            userName.setMaxAge(10);
//            response.addCookie(userName);