package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exceptions.InvalidInputException;
import com.provider.ObjectCreator;
import com.services.LoginServices;
import com.servicesImpl.LoginServicesImpl;

public class ControllerServlet extends HttpServlet {
	
	Connection con;
	
	public void init()
    {
    	//GET CONNECTION OBJECT USING SERVLET
    	
    	ServletContext context = getServletConfig().getServletContext();
    	con = (Connection)context.getAttribute("Dbcon");	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//1.KNOW THE REQUEST PAGE
		LoginServices service = ObjectCreator.createObject();
		((LoginServicesImpl) service).setConnection(con);
		String page = request.getParameter("page");
		
		if(page.equals("signin"))
		{
			//EXTRACT DATA FROM THE CLIENT SIDE
			String name = (String) request.getAttribute("user");
			String pass = request.getParameter("password");
			String sqn = request.getParameter("sqn");
			
			try
			{
				if(service.signIn(name, pass))
				{
					HttpSession session = request.getSession(true);
					session.setAttribute("user", name);
				
					RequestDispatcher rd = request.getRequestDispatcher("/Gadgets.html");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
					rd.include(request, response);
					out.println("INVALID CREDENTIALS, PLEASE TRY AGAIN");
				}
			}
			catch(InvalidInputException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(page.equals("signup"))
		{
			String name = request.getParameter("username");
			String pass = request.getParameter("psw");
			String sqn = request.getParameter("sqn");
			try{
				    if(service.signUp(name, pass, sqn))
				    {
				    	RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
						rd.forward(request, response);
				    	
				    }
				    else
				    {
				    	RequestDispatcher rd = request.getRequestDispatcher("/SignUp.html");
						rd.include(request, response);
						out.println("This username already exist, Please try any other username");
				    }
				
			}
			catch(InvalidInputException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}

}
