<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
<style>

h2 {font-family: Arial, Helvetica, sans-serif; color:#000000; text-align: center;}
p{font-family: Arial, Helvetica, sans-serif; color:#000000; text-align: center;}
body 
{
  	 background-image: url('logout.jpg');
 	 background-repeat: no-repeat;
 	 background-attachment: fixed;
     background-size: 100%100%;
}
a{
font-family: Arial, Helvetica, sans-serif;
color:#000000;}
a:hover {
  color: #0000ff;
}
</style>
</head>
<body>
<h2>THANK YOU FOR SHOPPING WITH US!</h2>
<hr>
<p>
<a href="LoginPage.html">LOGOUT</a>
</p>
</body>
</html>

<%
   session.invalidate();
%>

