package control;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.ItemMasterDAO;
import model.ItemMasterDAOimpl;
import model.ItemMasterDTO;


public class Item extends TagSupport{

	private String category;
	
	

	public final String getCategory() {
		return category;
	}



	public final void setCategory(String category) {
		this.category = category;
	}



	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
		JspWriter out=pageContext.getOut();
		Properties prop = (Properties)pageContext.getRequest().getServletContext().getAttribute("prop");
		ItemMasterDAO itemdao = new ItemMasterDAOimpl(prop);
		int i1 = Integer.parseInt(category);
		Set<ItemMasterDTO> itemdto = itemdao.getAllItemOfCategory(i1);
		HttpSession session = pageContext.getSession();
		Set<ItemMasterDTO> dto = new HashSet<ItemMasterDTO>();
		try {
			
			Iterator<ItemMasterDTO> itemset = itemdto.iterator();
		     while(itemset.hasNext()){
		    	 
		    	 ItemMasterDTO i = itemset.next();
		    	 
		    	 out.println(
		    	i.getItem_name()
		    	+":<input type=\"checkbox\" name=\""+i.getItem_no()
		    	+"\" value=\""+i.getItem_name()+"\"><br>");
		    	
		    	 
		     }
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return super.doEndTag();
	}
	
	
}
