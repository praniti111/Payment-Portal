<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Cart</title>

<style>

h2 {font-family: Arial, Helvetica, sans-serif; color:#000000; text-align: center;}
form {font-family: Arial, Helvetica, sans-serif; height:230px;color:#000000; text-align: center;}
body 
{
  	 background-image: url('laptopcart.jpg');
 	 background-repeat: no-repeat;
 	 background-attachment: fixed;
     background-size: cover;
}
a{color:#000000;}
a:hover {
  color: #0000ff;
}
</style>

</head>
<body >

<section id='outerBox'>
<form action = "log3" method = "post" style = "border:0px solid #ccc">
<h2> YOUR CART </h2>
<hr>

<%
String username = (String)session.getAttribute("user");
ArrayList arr = (ArrayList)session.getAttribute("arr");
Double amount = (Double)session.getAttribute("totalPrize");
out.println("Welcome user "+username);
%>
<br><br>
<% 
out.println("You have purchased "+" "+arr);
%>
<br><br>
<% 
out.println("Your total amount is Rs."+ amount);
%>
<br><br>

<a href='http://localhost:8080/PaymentGateway/PaymentPage.html'>CLICK HERE TO PAY THE BILL</a><br><br><br>
</form>
</section>
</body>
</html>