package CONTROLLER;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet 
{
	protected void service(HttpServletRequest x, HttpServletResponse y)
	{
		HttpSession hs=x.getSession();
		hs.invalidate();
		try {
			y.sendRedirect("/BANKAPP/Logoutpg.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
