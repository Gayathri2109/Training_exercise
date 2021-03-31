package service;

import java.util.Set;


import model.ItemMasterDTO;
import model.UserDTO;

public interface ShoppingService {
	public Set<ItemMasterDTO> showItems(int category);

}
