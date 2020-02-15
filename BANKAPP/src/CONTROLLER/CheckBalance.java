package CONTROLLER;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class CheckBalance extends HttpServlet 
{

	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		String accountno=(String) hs.getAttribute("accountno");
		Model m=new Model();
		m.setAccountno(accountno);
		
		boolean temp=m.Balance();
		if(temp==true)
		{
				String balance=m.getBalance();
				
				hs.setAttribute("balance", balance);
				System.out.println(accountno);
			try 
			{
				y.sendRedirect("/BANKAPP/BalanceSucess.jsp");
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
				y.sendRedirect("/BANKAPP/BalanceFailure.jsp");
			} 
			catch (IOException e) 
			{
				System.out.println("2");
			}
		}
	}
}

	