<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css">

</head>
<body>
<header>
<h1 style="background-color:#37F5A1;">Balance</h1>
</header>

<% 
HttpSession hs=request.getSession();
String balance=(String)hs.getAttribute("balance");
out.println("Your Balance is" +" "+ balance);
%>

<br>
<br>

<a href="Home.jsp"; style="background-color:#37F5A1;">Home</a>
</body>
</html>