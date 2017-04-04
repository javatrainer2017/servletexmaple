package com.javaexmples.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by javat on 3/30/2017.
 */
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
//        try {
//            response.getWriter().println("Get method invoked...");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        try {
            if (userName.equals("admin") && password.equals("admin")) {
                RequestDispatcher rd = request.getRequestDispatcher("/www/success.html");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/www/loginfailed.html");
                rd.forward(request, response);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
