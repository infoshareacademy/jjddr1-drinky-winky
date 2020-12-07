package com.infoshare.servlet;

import com.infoshare.dto.UserDto;
import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.LoggingService;
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

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        if (loggingService.checkUser(login).isPresent()) {
            UserDto registeredUserDto = loggingService.checkUser(login).orElseThrow();
            if (loggingService.checkPassword(registeredUserDto, password)) {

                HttpSession session = request.getSession(true);
                session.setAttribute("login", login);
                session.setAttribute("password", password);
                session.setAttribute("userType", userType);
                Writer out = response.getWriter();
                Map<String, Object> root = new HashMap<>();
                Template template = templateProvider.getTemplate(getServletContext(), "signed-in.ftlh");

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
