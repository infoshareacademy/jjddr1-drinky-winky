package com.infoshare.servlet;

import com.infoshare.model.Drink;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String TEMPLATE_DIR = "WEB-INF/template";
    private Configuration cfg;

    public StartServlet() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setServletContextForTemplateLoading(getServletContext(), TEMPLATE_DIR);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, Object> root = new HashMap<>();
//        root.put("save", "yes");

        if (request.getParameter("save").equals("YES")) {
            Template template = cfg.getTemplate("index.ftlh");
            Writer out = response.getWriter();

            try {
                template.process(root, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            Template template = cfg.getTemplate("say-goodbye.ftlh");
            Writer out = response.getWriter();

            try {
                template.process(root, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }


    }
}
