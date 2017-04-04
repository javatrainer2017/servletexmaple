package com.javaexmples.servlets;

import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by javat on 4/3/2017.
 */
public class SecondServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstValue = (String) request.getAttribute("firstValue");
        request.setAttribute("secondValue", "SecondServlet");
        HttpSession session =request.getSession(false);
        System.out.println(session.getAttribute("sessionAttribute"));

        if(firstValue == null)
        {
            response.sendRedirect(  request.getServletContext().getContextPath() + "/first");
        }
        for(Cookie cookie : request.getCookies())
        {
            response.getWriter().println(cookie.getName() + "   " + cookie.getValue());
        }
        String str = request.getServletContext().getInitParameter("GlobalOne");

        response.getWriter().println("Global Value found " + str);
        response.getWriter().println("Value found " + firstValue);
        response.getWriter().println("Context path " + request.getServletContext().getContextPath());
    }
}
