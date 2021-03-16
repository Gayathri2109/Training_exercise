package Assignment;

import java.io.Serializable;
import java.util.Set;

public interface ItemTransactionDAO extends Serializable {

	public int insertItem(ItemTransactionDTO itemTransactionDTO);
	public int deleteItem(int itemNo);
	public int updateItem(ItemTransactionDTO itemTransactionDTO);
	public ItemTransactionDTO getItemMaster(int itemNo);
	public Set<ItemTransactionDTO> getItemMasterAll();
	
}
