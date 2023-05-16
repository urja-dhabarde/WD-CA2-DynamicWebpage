<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<title>Sign In Page</title>
<head>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: blue;
}

* {
  box-sizing: border-box;
}

.content {
  max-width: 960px;
  margin:left;
}

.container {
  width:50%;
  padding: 40px;
  background-color: white;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

.registerbtn {
  background-color: #04AA6D;
  color: white;
  font-size: 20px;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
  opacity: 0.9;
}



/* Add a blue text color to links */
a {
  color: dodgerblue;
}
span.psw {
  float: left;
  position:relative;
  bottom:30px;
  
}

.signin {
  background-color: #f1f1f1;
  text-align: left;
}

@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  
</style>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

<form action="<%=request.getContextPath()%>/login" method="post">

<div class="container" align="center">
<h1>Sign In </h1>
<table>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <input type="submit" value="Sign In" class="registerbtn"/>

</div>

</form>

<div class="container signin">
    <p>Don't have an account?  <a  href="${pageContext.request.contextPath}/register">Register Here</a></p><br><br>

    <span class="psw">Forgot <a href="${pageContext.request.contextPath}/forgot">password?</a></span>

    
</div>
</body>
</html>