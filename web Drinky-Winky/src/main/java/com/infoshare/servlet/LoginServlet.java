package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
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

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> root = new HashMap<>();

        String login = request.getParameter("login");
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        //setting session to expiry in 10s
        session.setMaxInactiveInterval(10);

        Template template = templateProvider.getTemplate(getServletContext(), "log.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//
//        if (login.equals(login) && password.equals("password")) {
//            HttpSession session = request.getSession();
//            session.setAttribute("login", login);
//
//            //setting session to expiry in 30 mins
//            session.setMaxInactiveInterval(30 * 60);
//
//            Cookie userName = new Cookie("login", login);
//            userName.setMaxAge(30 * 60);
//            response.addCookie(userName);
//
//            response.sendRedirect("/User-view");
//        } else {
//            response.sendRedirect("log");
//        }
