package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.utils.SearchEngineUtils;
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

@WebServlet("/find-by-filters")
public class SearchByFiltersServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    SearchEngineUtils searchEngineUtils;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String category = request.getParameter("category");
        String glass = request.getParameter("glassType");
        String type = request.getParameter("drinkType");

        Map<String, Object> root = new HashMap<>();
        root.put("names", searchEngineUtils.findDrinkByFilters(category, glass, type));
        Template template = templateProvider.getTemplate(getServletContext(), "filters-search.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
