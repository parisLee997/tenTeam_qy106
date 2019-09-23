package com.aaa.fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ipFilter",urlPatterns = "/*")
public class ipFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response=(HttpServletResponse)resp;

        //remote 远程
        String ip=req.getRemoteAddr();
        if(ip.indexOf("192.")>-1){
            response.sendError(HttpServletResponse.SC_CONFLICT,"禁止该ip");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
