package com.listener;

import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.sql.Connection;

public class ContextConnectionListener implements ServletContextListener {

	Connection con = null;
	
    public void contextDestroyed(ServletContextEvent e1) {
    	try
    	{
    		con = (Connection) e1.getServletContext().getAttribute("Dbcon");
    		con.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        
    }

	
    public void contextInitialized(ServletContextEvent e1) {
        ServletContext context = e1.getServletContext();
        
        String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		
		try
    	{   		
    		Class.forName(driver);
    		con = DriverManager.getConnection(url+"useSSL=false&serverTimezone=UTC",username,password);
    		context.setAttribute("Dbcon",con);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }
	
}
