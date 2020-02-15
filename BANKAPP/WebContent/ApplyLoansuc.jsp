<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
HttpSession hs=request.getSession();
String name=(String)hs.getAttribute("name");
out.println("Thanks you" +" "+ name+" "+"For Having Interest in loan.We will get back to you.");
%>
</body>
</html>