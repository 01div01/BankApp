package CONTROLLER;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


 
public class PwdFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PwdFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		if(password.equals(confirmpassword)==true)
		{
		chain.doFilter(request, response);
		System.out.println("validated");
		}
		else
		{
			((HttpServletResponse)(response)).sendRedirect("/BANKAPP/ChangepwdFail.jsp");
			System.out.println("error exeecuted");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
