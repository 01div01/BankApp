package CONTROLLER;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class GetLogin extends HttpServlet 
{
	String accountno=null;
	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		String customerid=x.getParameter("customerid");
		String password=x.getParameter("password");
		Model m=new Model();
		m.setCustomerid(customerid);
		m.setPassword(password);
		boolean temp=m.getLogin();
		if(temp==true)
		{
				String accountno=m.getAccountno();
				HttpSession hs=x.getSession(true);
				hs.setAttribute("accountno", accountno);
				System.out.println(accountno);
			try 
			{
				System.out.println("1");
				y.sendRedirect("/BANKAPP/Home.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("1");
			}
		}
		else
		{
			try 
			{
				System.out.println("2");
				y.sendRedirect("/BANKAPP/ErrorHome.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("2");
			}
		}
	}
	
	
}
