//package com.aaa.fliter;
//
//import com.sun.deploy.net.HttpResponse;
//
//import javax.jms.Session;
//import javax.naming.Context;
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.jsp.PageContext;
//import java.io.IOException;
//
//@WebFilter(filterName = "longinFilter",urlPatterns = {"/admin/*","*.action"})
//public class longinFilter implements Filter {
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse)resp;
//        HttpSession session = request.getSession();
//        if (req.getRemoteAddr().indexOf("login")>-1){
//            chain.doFilter(req,resp);
//        }else {
//            if (session.getAttribute("user") == null) {
//                response.sendRedirect(request.getContextPath()+"/login.jsp");
//            } else {
//                chain.doFilter(req, resp);
//            }
//
//        }
//
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
