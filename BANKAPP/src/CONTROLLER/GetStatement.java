package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class GetStatement extends HttpServlet 
{
	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String accountno=(String) hs.getAttribute("accountno");
		Model m=new Model();
		m.setAccountno(accountno);	
		ArrayList al=m.getStmt();
		System.out.println(al);
		if(al.isEmpty()==false)
		{
				hs.setAttribute("al", al);
				System.out.println(accountno);
			try 
			{
				y.sendRedirect("/BANKAPP/GetstmtSuc.jsp");
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
				y.sendRedirect("/BANKAPP/GetstmtFail.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("2");
			}
		}
	}
}
	