<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your Statement for</h1>

<%
ArrayList<Object> ll=new ArrayList<Object>();
HttpSession hs=request.getSession();
String accountno=(String)hs.getAttribute("accountno");
ll.add(hs.getAttribute("al"));


//ListIterator itr=ll.listIterator();
//while(itr.hasNext()==true)
//{
out.println("Statement for Account No:" +" " + accountno +" " + "is ");

request.setAttribute("list", ll);
%>

 <c:forEach items="${list}" var="value">
  <div><c:out value="${value}"/></div>
 </c:forEach>

<br>
<br>

<a href="Home.jsp"; style="background-color:#37F5A1;">Home</a>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</body>
</html>