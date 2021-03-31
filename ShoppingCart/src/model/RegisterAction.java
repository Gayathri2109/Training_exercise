package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class RegisterAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("uname");
		String upass=(String)session.getAttribute("upass");
		
		UserDTO userdto = new UserDTO();
		userdto.setFlag(0);
		userdto.setUid(++i);
		userdto.setUname(uname);
		userdto.setUpass(upass);
		
		Properties prop=(Properties)request.getServletContext().getAttribute("properties");

		LoginService loginService=LoginServiceImpl.getLoginServiceImpl(prop);
		
		loginService.registerUser(userdto);
		
		return "register.success";
	}
}
