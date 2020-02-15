<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<form action="http://localhost:5001/BANKAPP/CheckBalance">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<header>
<h1 style="background-color:#37F5A1;">Login Successful</h1>
</header>

<% 
HttpSession hs=request.getSession();
String accountno=(String)hs.getAttribute("accountno");
out.println("Your Account number is" +" "+ accountno);
%>


<table>
<div>
<tr>
<td><input type="submit" class="button" value="Check Balance"></td>

</tr>
</div>
</table>
<br>
<tr><td>
<a href="ChangePassword.jsp" class="button">Click Here To Change Password</a></td></tr>
<br><br>
<tr><td>
<a href="ChoseBank.jsp" class="button">Click Here To Transfer</a></td></tr>
<br><br>
<tr><td>
<a href="GetStatement" class="button">Click Here To Get Statement</a></td></tr>
<br><br>
<tr><td>
<a href="ApplyLoan.jsp" class="button">Click Here To Apply For Loan</a></td></tr>
<br><br>
<tr><td>
<a href="Logout" class="button">Logout</a></td></tr>
<style type="text/css">

        .button { background-color: #00CCFF; padding: 8px 30px; display: inline-block; text-decoration: none; color: #FFFFFF border-radius: 3px;}

        .button:hover { background-color: #0066FF; }

    </style>
</body>
</html>