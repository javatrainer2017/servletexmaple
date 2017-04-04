package com.javaexmples.servlets;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by javat on 3/29/2017.
 */
public class HelloServlet extends GenericServlet implements SingleThreadModel{

    int count = 0;

    public void init(ServletConfig config)
    {
        System.out.println("Init method is called........");
        count = Integer.parseInt(config.getInitParameter("initialValue"));
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<h1> Hello World</h1>");
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            //do nothing
        }
        writer.println("The count is " + count++);
        writer.println("The request parameter is " + servletRequest.getAttribute("test"));
    }

    public void destroy()
    {
        System.out.println("Destory method is called....");
    }
}
