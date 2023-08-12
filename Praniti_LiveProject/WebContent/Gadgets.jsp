<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
  String tech = request.getParameter("gadgetname");
  	if(tech.equalsIgnoreCase("mobile"))
  	{
%>
		<jsp:forward page = "Mobile.jsp"/>
<% 
   	}
  	else if(tech.equalsIgnoreCase("laptop"))
  	{
 %> 
 		<jsp:forward page = "Laptop.jsp"/>
 <%		
  	}
  	else if(tech.equalsIgnoreCase("headphone"))
  	{
%>
       <jsp:forward page = "Headphone.jsp"/>
<%		
  	}
%>