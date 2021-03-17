package DataBase;

import java.util.Set;


public interface ItemMasterDAO{

	public int insertItem(ItemMasterDTO itemMasterDTO);
	public int deleteItem(int itemNo);
	public int updateItem(ItemMasterDTO itemMasterDTO);
	public ItemMasterDTO getItemMaster(int itemNo);
	public Set<ItemMasterDTO> getItemMasterAll();
}
