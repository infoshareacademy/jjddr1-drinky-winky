package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Logout")
public class LogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession() != null) {
            request.getSession().invalidate();

            Map<String, Object> root = new HashMap<>();

            Template template = templateProvider.getTemplate(getServletContext(), "userSignedOut.ftlh");
            Writer out = response.getWriter();

            try {
                template.process(root, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }


        //        Cookie cookie = new Cookie ("userName", "");
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
    }
}