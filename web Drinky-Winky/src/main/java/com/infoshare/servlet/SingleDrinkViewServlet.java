package com.infoshare.servlet;

import com.infoshare.freemarker.BfTemplateProvider;
import com.infoshare.service.DrinkService;
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

@WebServlet("/single")
public class SingleDrinkViewServlet extends HttpServlet {

    @Inject
    private DrinkService drinkService;

    @Inject
    private BfTemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String paramId = request.getParameter("id");

        if (paramId == null || paramId.isBlank()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        Map<String,Object> drinkModel = new HashMap<>();

        Long id = Long.valueOf(paramId);

        drinkModel.put("drink", drinkService.getDrinkById(id));

        Template template = templateProvider.getTemplate(getServletContext(),"singleDrink.ftlh");

        PrintWriter printWriter = response.getWriter();

        try {
            template.process(drinkModel, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
