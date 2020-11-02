package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.CategoryService;
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

@WebServlet("/Category-list")
public class CategoryListServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    CategoryService categoryService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();
        root.put("categories", categoryService.getCategoriesList());

        Template template = templateProvider.getTemplate(getServletContext(), "category.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root,out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
