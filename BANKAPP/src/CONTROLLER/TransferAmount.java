package CONTROLLER;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class TransferAmount extends HttpServlet 
{
	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		String amount=x.getParameter("amount");
		HttpSession hs=x.getSession();
		String accountno=(String) hs.getAttribute("accountno");
		Model m=new Model();
		System.out.println(amount+accountno);
		m.setAccountno(accountno);
		boolean temp=m.transfer(amount);
		if(temp==false)
		{
			try 
			{
				y.sendRedirect("/BANKAPP/TransferFail.jsp");
				System.out.println("1");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("2");
				e.printStackTrace();
			}
			
		}
		else
		{
			try 
			{
				y.sendRedirect("/BANKAPP/TransferSucess.jsp");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
	