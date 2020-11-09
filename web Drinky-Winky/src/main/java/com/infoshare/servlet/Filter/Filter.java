//package com.infoshare.servlet.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(
//        filterName = "authorisation",
//        servletNames = "/User-view",
//        urlPatterns = "/Admin/*",
//        initParams = {
//                @WebInitParam(name = "userType", value = "admin"),
//                @WebInitParam(name = "userType", value = "custom")
//}
//)
//public class Filter implements javax.servlet.Filter{
//
//    private String admin;
//    private String custom;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    admin = filterConfig.getInitParameter("userType");
//    custom = filterConfig.getInitParameter("custom");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String userType = (String) req.getSession().getAttribute("userType");
//        if((userType == null) && !(userType.equals(admin))){
//            resp.sendRedirect("Start");
//        }
//        String path = req.getServletPath();
//        if((path.equals("Admin")) && !(userType.equals(admin))){
//            resp.sendRedirect("Start");
//        }
//        if((path.equals("User-view")) && !(userType.equals(custom))){
//            resp.sendRedirect("Start");
//        }
//        chain.doFilter(servletRequest, servletResponse);
//    }
//}
