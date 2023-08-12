<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Headphone Selection</title>

<style>
h2 {text-align: center;font-family: Arial, Helvetica, sans-serif; }
form {text-align: center;font-family: Arial, Helvetica, sans-serif;}
body {
  background-image: url('headphone.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100%100%;
}
button {
  color: #fff;
  cursor: pointer;
  background-color: #000000;
  border-color: #000000;
  border-radius: 3px;
  width: 100px;
  height: 20px;
}
button:hover {
  background-color: #0066ff;
  border-color: #10707f;
  box-shadow: 0 0 0 2px rgba(0,92,230,.5);
}

</style>

</head>
<body>

<h2>SELECT THE REQUIRED HEADPHONE</h2>

<form action = "log5" method = "post">
  <label for="gadget">CHOOSE A LAPTOP:</label>
  <select name="gadget" id="gadget">
    <option value="Boat">Boat</option>
    <option value="JBL">JBL</option>
    <option value="Sony">Sony</option>
  </select>
  <br><br>
  <button type="submit">SELECT</button>
  <input type="hidden" name="page" value="headphone"/>
</form>

</body>
</html>

