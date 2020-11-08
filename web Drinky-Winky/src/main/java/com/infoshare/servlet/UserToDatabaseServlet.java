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

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setSurname(surName);
        userDTO.setLogin(login);
        userDTO.setPassword(password);

        userService.saveUser(userDTO);

        Map<String, Object> root = new HashMap<>();
        Template template = templateProvider.getTemplate(getServletContext(), "Start.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
