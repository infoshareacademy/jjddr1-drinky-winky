package com.infoshare.servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "authorisation",
        urlPatterns = {"/Admin/*", "/User-view/*"},
        initParams = {
                @WebInitParam(name = "userType", value = "custom"),
        }
)
public class Filter implements javax.servlet.Filter {


    private String login;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        login = filterConfig.getInitParameter("login");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String path = req.getServletPath();
        String loginUser = (String) req.getSession().getAttribute("login");

        if (loginUser == null || loginUser.isEmpty()) {
            resp.sendRedirect("/Login");
        } else if (path.equals("/Admin") && !(login.equals("login"))) {
            resp.sendRedirect("/Start");
        }


        chain.doFilter(servletRequest, servletResponse);
    }
}

