package com.infoshare.servlet;

import com.infoshare.dto.MessageDto;
import com.infoshare.freemarker.TemplateProvider;
import com.infoshare.service.MessageService;
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

@WebServlet("/Start")
public class StartServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    MessageService messageService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        messageService.saveMessage(new MessageDto(1L,"HELLO START"));
        Map<String, Object> root = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), "start.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
