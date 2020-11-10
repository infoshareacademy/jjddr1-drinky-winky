package com.infoshare.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.IOException;

@RequestScoped
public class BfTemplateProvider {

    private final String TEMPLATE_DIRECTORY_PATH = "WEB-INF/template";
    private Configuration configuration;
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private ConfigLoader configLoader;

    public Template getTemplate(ServletContext servletContext, String templateName)
            throws IOException {

        configuration = configLoader.loadConfiguration();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATE_DIRECTORY_PATH);
        logger.info("Getting freemarker template");
        return configuration.getTemplate(templateName);
    }
}