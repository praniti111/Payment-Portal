package com.dataInput;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/log5")
public class DataInputServlet extends HttpServlet {

	Connection con;
	PreparedStatement pst;
    ResultSet rs;
    ArrayList item;
    
    public void init()
    {
    	item = new ArrayList<String>();
    	
        //GET CONNECTION OBJECT USING SERVLET
    	
    	ServletContext context = getServletConfig().getServletContext();
    	con = (Connection)context.getAttribute("Dbcon");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//EXTRACT DATA FROM CLIENT
		String name = request.getParameter("gadget");
		item.add(name);
		
		//EXTRACTING DATA FROM THE EXISTING SESSION OBJECT
		
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("user");
		String page = request.getParameter("page");
		
		//PUTTING ITEM IN THE CART
		session.setAttribute("item1",item);
	
		BigDecimal amount;
		Double totalAmount=0.0;
		
		ArrayList<String> arr = (ArrayList) session.getAttribute("item1");
		
		if(page.equals("mobile"))
		{
			try
			{
				for(String name1:arr){
					pst = con.prepareStatement("select * from gadget_table where name = ?");
					pst.setString(1,name1);
					rs = pst.executeQuery();
				
					while(rs.next()){
						amount =  rs.getBigDecimal("price");
						totalAmount = totalAmount + amount.doubleValue();
					}
				}		

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(page.equals("laptop"))
		{
			try
			{
				for(String name1:arr){
					pst = con.prepareStatement("select * from laptop_table where name = ?");
					pst.setString(1,name1);
					rs = pst.executeQuery();
				
					while(rs.next()){
						amount =  rs.getBigDecimal("price");
						totalAmount = totalAmount + amount.doubleValue();
					}
				}		

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(page.equals("headphone"))
		{
			try
			{
				for(String name1:arr){
					pst = con.prepareStatement("select * from headphone_table where name = ?");
					pst.setString(1,name1);
					rs = pst.executeQuery();
				
					while(rs.next()){
						amount =  rs.getBigDecimal("price");
						totalAmount = totalAmount + amount.doubleValue();
					}
				}		

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	    
		session.setAttribute("totalPrize", totalAmount);
		session.setAttribute("arr", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("/BillingPage.jsp");
		rd.forward(request,response);
		

		
	}

}
