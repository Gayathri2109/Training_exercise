package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ShoppingCartAction extends Action{
	static int n = 1;
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String shopid=request.getParameter("shopid");
	Properties prop=(Properties)request.getServletContext().getAttribute("properties");
	HttpSession session = request.getSession();
	
	
	
//	ShoppingService ser = ShoppingServiceImpl.getUserDAOImpl(prop);
//	Set<ItemMasterDTO> set = ser.getAll(++n);
//	System.out.println(set);
//	System.out.println(shopid);
//	session.setAttribute(shopid, set);
	
	Enumeration<String> e=request.getParameterNames();
	while(e.hasMoreElements()) {
		String name=e.nextElement();
		String value=request.getParameter(name);
		session.setAttribute(name, value);
	}
	
	return shopid;
}

//public static void main(String[] args) throws FileNotFoundException, IOException {
//	Properties prop = new Properties();
//	prop.load(new FileInputStream("dbconfig.properties"));
//	ShoppingService ser = ShoppingServiceImpl.getUserDAOImpl(prop);
//	Set<ItemMasterDTO> set = ser.getAll(2);
//	System.out.println(set);
//	
//}

}
