package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.DrinkService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

@WebServlet("/User-view")
public class UserViewServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    DrinkService drinkService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, Object> root = new HashMap<>();

        int size = drinkService.getDrinkList().size();
        int numberOfPage = 1;
        List<Integer> pages = new ArrayList<>();

        if (size != 0) {
            if (size % 8 == 0) {
                numberOfPage = size / 8;
            } else {
                numberOfPage = size / 8 + 1;
            }
        }

        for (int pageNumber = 1; pageNumber <= numberOfPage; pageNumber++) {
            pages.add(pageNumber);
        }

        String page = request.getParameter("page");
        if (page.equals("user")) {
            root.put("drinkList", drinkService.getRequestDrinkList(numberOfPage, 8));
            root.put("allDrink", drinkService.getDrinkList());
        } else {
            int i = Integer.parseInt(page);
            root.put("allDrink", drinkService.getDrinkList());
            root.put("drinkList", drinkService.getRequestDrinkList(i, 8));
            root.put("pageNumber", pages);
        }


        Template template = templateProvider.getTemplate(getServletContext(), "user-view.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
