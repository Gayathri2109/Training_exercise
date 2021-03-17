package DataBase;

public class ItemMasterDTO {

	private int itemNo;
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final String getItemName() {
		return itemName;
	}
	public final void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public final int getItemPrice() {
		return itemPrice;
	}
	public final void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public final int getItemQuantity() {
		return itemQuantity;
	}
	public final void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	@Override
	public String toString() {
		return "ItemMasterDTO [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemQuantity=" + itemQuantity + "]";
	}
	
	
	
	
}
