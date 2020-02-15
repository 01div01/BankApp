package CONTROLLER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;


public class ApplyLoan extends HttpServlet 
{
	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String accountno=(String) hs.getAttribute("accountno");
		Model m=new Model();
		m.setAccountno(accountno);	
		
		
		
		boolean temp=m.applyLoan();
		if(temp==true)
		{
				String name=m.getName();
				
				hs.setAttribute("name", name);
				System.out.println(name);
			try 
			{
				y.sendRedirect("/BANKAPP/ApplyLoansuc.jsp");
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
				y.sendRedirect("/BANKAPP/ApplyLoanFail.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("2");
			}
		}
	}
}
	