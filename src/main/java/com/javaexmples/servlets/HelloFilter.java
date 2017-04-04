package com.javaexmples.servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by javat on 3/31/2017.
 */
public class HelloFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String testValue = (String) servletRequest.getAttribute("test");
        System.out.println("Test value is " + testValue );
        testValue = "MyFirstFilterValue";
        servletRequest.setAttribute("test", testValue);
        filterChain.doFilter(servletRequest,servletResponse);
        //XSS Cross side script
        //Compression
    }

    public void destroy() {

    }
}
