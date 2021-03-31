package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LogoutAction;
import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

	private ArrayList<String> urlList;
	
	public void destroy() {
		System.out.println("Filter destroyed is called....");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Do Filter is called....");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		chain.doFilter(req, res);
		
		HttpSession session = req.getSession();
		if(session.isNew())
		{
			String s = req.getParameter("formid");
			System.out.println(s);
			if(s.equals("lang")) {
				chain.doFilter(req, res);
			}else {
				res.sendRedirect("expired.html");
			}
		}
		else {
			chain.doFilter(req, res);
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter init is called.....");

	}
}

