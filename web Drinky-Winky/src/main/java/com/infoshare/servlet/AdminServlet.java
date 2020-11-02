package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "admin.ftlh");

        Map<String, Object> dataModel = new HashMap<>();

        PrintWriter writer = response.getWriter();
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
