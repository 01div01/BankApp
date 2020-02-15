<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<form action="http://localhost:5001/BANKAPP/GetLogin">
<body>
<style>
body {
  background-image: url('https://images.unsplash.com/photo-1564606121372-d310470df1b6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
  background-size:cover;
}
</style>
<header>
<h1 style="background-color:#37F5A1;">Let's, Get Started</h1>
</header>

<table>

<tr>
<td>Customer ID</td> 
<td><input type="text" name="customerid"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="login" ></td>
</tr></table>
<table>
<tr><td><a href="Forgetpwd.jsp">Forget Password</a></td></tr>
</table>
</body>
</html>