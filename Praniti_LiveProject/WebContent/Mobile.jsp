<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile Selection</title>

<style>
h2 {text-align: center;font-family: Arial, Helvetica, sans-serif; }
form {text-align: center;font-family: Arial, Helvetica, sans-serif;}
body {
  background-image: url('mobile.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
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

<h2>SELECT THE REQUIRED SMARTPHONE</h2>

<form  action = "log5" method = "post">
  <label for="gadget">CHOOSE A PHONE:</label>
  <select name="gadget" id="gadget">
    <option value="RealmeNarzo 10">RealmeNarzo 10</option>
    <option value="Galaxy M32">Galaxy M32</option>
    <option value="OnePlus Nord 2">OnePlus Nord 2</option>
    <option value="Nokia G20">Nokia G20</option>
    <option value="iPhone 11">iPhone 11</option>
  </select>
  <br><br>
  <button type="submit">SELECT</button>
  <input type="hidden" name="page" value="mobile"/>
</form>

</body>
</html>




