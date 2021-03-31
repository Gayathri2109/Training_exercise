package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.ItemMasterDAO;
import model.ItemMasterDAOimpl;
import model.ItemMasterDTO;


public class PurchaseList extends TagSupport{
	
	private String category;
	
	
	public final String getName() {
		return category;
	}

	public final void setName(String category) {
		this.category = category;
	}

	
	public static boolean isNumeric(String category) {
	    if (category == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(category);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out=pageContext.getOut();
		HttpSession mysession = pageContext.getSession();
		
		//Properties prop = (Properties)pageContext.getRequest().getServletContext().getAttribute("prop");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("dbconfig.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ItemMasterDAO itemdao = ItemMasterDAOimpl.getItemDAOImpl(prop);
		ItemMasterDTO itemDTO = new ItemMasterDTO();
		int total = 0;
		Enumeration<String> e = mysession.getAttributeNames();
		while(e.hasMoreElements()){
			
			String name = e.nextElement();
			
			if(isNumeric(name)) {
				
				String value = (String)mysession.getAttribute(name);
				
				try {
					
					itemDTO = itemdao.getItem(Integer.parseInt(name));
					
					out.println("<h5>"+itemDTO.getItem_no()+" | "
					+itemDTO.getItem_name()+" - "
					+itemDTO.getItem_price()+"</h5>");
					
					total+=itemDTO.getItem_price();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}			
		}
		
		
		try {
			out.println("<h2>Gross Total Rs : "+ total +"/-</h2>");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return super.doEndTag();
	}
}
