package com.infoshare.servlet;

import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.DrinkService;
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

@WebServlet("/User-view")
public class UserViewServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;
    @Inject
    DrinkService drinkService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//        Cookie[] cookies = request.getCookies();
//        for(Cookie c: cookies) {
//            if (c.getName().equals("userName")) {

        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(60);
        Object login = session.getAttribute("login");
        if(login == null){
            response.sendRedirect("Logout");
        }
                Map<String, Object> root = new HashMap<>();
                root.put("drinkList", drinkService.getRequestDrinkList(1, 8));
                root.put("allDrink", drinkService.getDrinkList());

                Template template = templateProvider.getTemplate(getServletContext(), "user-view.ftlh");
                Writer out = response.getWriter();

                try {
                    template.process(root, out);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
//            } else{
//
    }
}
