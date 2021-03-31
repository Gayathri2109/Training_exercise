package model;

import java.util.Set;


public interface ItemMasterDAO{
	
		public int insertItem(ItemMasterDTO itemDTO);
		public int updateItem(ItemMasterDTO itemDTO);
		public int deleteItem(int item_no);
		public ItemMasterDTO getItem(int item_no);
		public Set<ItemMasterDTO> getAllItem();
		public Set<ItemMasterDTO> getAllItemOfCategory(int category);

}
