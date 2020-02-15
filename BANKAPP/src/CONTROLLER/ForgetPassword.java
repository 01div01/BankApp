package CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Model;

public class ForgetPassword extends HttpServlet 
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	{
		String password=request.getParameter("password");
		HttpSession hs=request.getSession();
		System.out.println(hs.getAttribute("emailid")+"hgytygytutrytyrty");
		String emailid=(String)hs.getAttribute("emailid");
		
		//String emailid=(String)hs.getAttribute("emailid");

		System.out.println(emailid+" "+password);
		
		Model m=new Model();
		m.setPassword(password);
		boolean temp=m.forgetPwd(emailid);
		if(temp==true)
		{
			try 
			{
				response.sendRedirect("/BANKAPP/ChangeForgetsuc.jsp");
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
				response.sendRedirect("/BANKAPP/ChangeForgetfail.jsp");
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
	
