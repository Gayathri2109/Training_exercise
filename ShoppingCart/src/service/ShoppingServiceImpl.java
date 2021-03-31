package service;


import java.util.Properties;
import java.util.Set;


import model.ItemMasterDAO;
import model.ItemMasterDAOimpl;
import model.ItemMasterDTO;


public class ShoppingServiceImpl implements ShoppingService,Cloneable{
	
	Properties prop;
	private static ShoppingServiceImpl shoppingserviceimpl; 
	private ShoppingServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static ShoppingServiceImpl getUserDAOImpl(Properties prop) {

		if(shoppingserviceimpl==null) {
			shoppingserviceimpl=new ShoppingServiceImpl(prop);
			return shoppingserviceimpl;
		}
		else {
			return shoppingserviceimpl.createClone();
		}
	}
	
	
	synchronized public ShoppingServiceImpl createClone() {
		try {
			return (ShoppingServiceImpl)super.clone();
		}catch(Exception e) {
			return null;
		}
		
}

	@Override
	public Set<ItemMasterDTO> showItems(int category) {
		
		ItemMasterDAO itemdao = ItemMasterDAOimpl.getItemDAOImpl(prop);
		Set<ItemMasterDTO> itemdto = itemdao.getAllItemOfCategory(category);
		
		return itemdto;
	}

}
