package com.infoshare.servlet;

import com.infoshare.dto.UserDTO;
import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.model.User;
import com.infoshare.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/RegUser")
public class UserToDatabaseServlet extends HttpServlet {
    @Inject
    UserService userService;
    @Inject
    TemplateProvider templateProvider;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        Writer out = response.getWriter();

        if (userService.findUserByLogin(login).isPresent()) {
            Map<String, Object> root1 = new HashMap<>();
            Template template = templateProvider.getTemplate(getServletContext(), "userExist.ftlh");

            try {
                template.process(root1, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {

            String name = request.getParameter("name");
            String surName = request.getParameter("surname");
            String password = request.getParameter("password");


            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surName);
            user.setUserType("user");
            UserDTO userDTO = UserDTO.userToDto(user);
            userService.saveUser(userDTO);

            Map<String, Object> root2 = new HashMap<>();
            Template template = templateProvider.getTemplate(getServletContext(), "newUserRegistered.ftlh");

            try {
                template.process(root2, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
//        } else response.sendRedirect("Login");
        }
    }
}
