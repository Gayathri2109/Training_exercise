package model;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ShoppingAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
//	String shopid=request.getParameter("shopid");
//	Properties prop=(Properties)request.getServletContext().getAttribute("properties");
//	HttpSession session = request.getSession();
//	
//	
//	
//	ShoppingService ser = ShoppingServiceImpl.getUserDAOImpl(prop);
//	Set<ItemMasterDTO> set = ser.getAll(1);
//	System.out.println(set);
//	session.setAttribute(shopid, set);
	
	return "shop.success";
}
}
