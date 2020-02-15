package CONTROLLER;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class ChangePassword extends HttpServlet 
{
	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		String password=x.getParameter("password");
		HttpSession hs=x.getSession();
		String accountno=(String) hs.getAttribute("accountno");
		Model m=new Model();
		m.setAccountno(accountno);
		m.setPassword(password);
		boolean temp=m.chPaswword();
		if(temp==false)
		{
			try 
			{
				y.sendRedirect("/BANKAPP/ChangepwdFail.jsp");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try 
			{
				y.sendRedirect("/BANKAPP/ChangepwdSuccess.jsp");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
