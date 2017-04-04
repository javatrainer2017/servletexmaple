package com.javaexmples.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by javat on 4/3/2017.
 */
public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("firstValue", "Test Value from Servlet");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("sessionAttribute") == null)
        {
            System.out.println("Session got timed out...or new session...");

            session.setAttribute("sessionAttribute", "SessionValue1");
        }
        else {
            System.out.printf("Printing value " + session.getAttribute("sessionAttribute"));
        }
        session.setMaxInactiveInterval(10);
        RequestDispatcher rd = request.getRequestDispatcher("/second");
        response.getWriter().println("Calling first servlet...");
        String str = request.getServletContext().getInitParameter("GlobalOne");
        response.addCookie(new Cookie("myCookie", str));
        rd.forward(request, response);
    }
}
