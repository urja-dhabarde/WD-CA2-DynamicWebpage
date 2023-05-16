<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserAccount Register Form</title>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: blue;
     }

.content 
    {
  max-width: 960px;
  margin:left;
    }

.container 
    {
  width:50%;
  padding: 40px;
  background-color: white;
    }
input[type=text], input[type=password] 
    {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
    }
input[type=text]:focus, input[type=password]:focus 
    {
  background-color: #ddd;
  outline: none;
    }
.registerbtn 
    {
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
.signup {
  background-color: #f1f1f1;
  
}

</style>
</head>
<body>
 
<div class="content">
  

  <form action="<%= request.getContextPath() %>/register" method="post">

  <div class="container" align="center">

<div class="signup">  <h1>SignUp</h1></div>
   <table>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Secretcode</td>
     <td><input type="text" name="secretcode" /></td>
    </tr>
    </table>

   
   <input type="submit" value="Submit" class="registerbtn" />

    </div>

  </form>
 </div>
</body>
</html>
