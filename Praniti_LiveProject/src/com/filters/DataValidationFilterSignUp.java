package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class DataValidationFilterSignUp implements Filter {

    public DataValidationFilterSignUp() {
        // TODO Auto-generated constructor stub
    }
    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("username");
		String pass = request.getParameter("psw");
		String sqn = request.getParameter("sqn");
		if(name != null && name !="")
		{
			if(pass!= null && pass.length()>=3)
			{
				if(sqn != null && sqn !="")
				{
					chain.doFilter(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/SignUp.html");
					rd.include(request, response);
					out.println("INVALID SQN,SQN SHOULD NOT BE NULL");
				}				
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SignUp.html");
				rd.include(request, response);
				out.println("INVALID PASSWORD,PASSWORD SHOULD BE GREATER THAN 3 CHARACTERS,PLEASE TRY AGAIN");
			}							
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/SignUp.html");
			rd.include(request, response);
			out.println("INVALID USERNAME,USERNAME SHOULD NOT BE NULL,PLEASE TRY AGAIN");
			
		}
	}
		
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
