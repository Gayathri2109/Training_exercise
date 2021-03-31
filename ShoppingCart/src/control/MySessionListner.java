package control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.LoginService;
import service.LoginServiceImpl;

/**
 * Application Lifecycle Listener implementation class MySessionListner
 *
 */
public class MySessionListner implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se)  { 
      System.out.println("Session created called.....");
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session destroyed called.....");
		HttpSession session = se.getSession();
		Properties prop=(Properties)session.getServletContext().getAttribute("properties");
		LoginService loginService=LoginServiceImpl.getLoginServiceImpl(prop);
		Object n = session.getAttribute("uname");
		if(n!=null) {
			String unmae=(String)n;
			loginService.updateFlag(unmae, 0);
		}
    }
	
}
