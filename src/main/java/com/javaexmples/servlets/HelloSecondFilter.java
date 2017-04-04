package com.javaexmples.servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by javat on 4/3/2017.
 */
public class HelloSecondFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String testValue = (String) servletRequest.getAttribute("test");
        System.out.println("Test value is " + testValue );

        testValue = "MySecondFilterValue";
        servletRequest.setAttribute("test", testValue);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
