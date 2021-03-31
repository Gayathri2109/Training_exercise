package model;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String Language = request.getParameter("language");
		System.out.println(Language);
		ResourceBundle rb = ResourceBundle.getBundle("model.Dictionary",new Locale(Language));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("rb", rb);
		
		return "lang.success";
	}
}
