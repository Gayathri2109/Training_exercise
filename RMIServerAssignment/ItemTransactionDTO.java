package Assignment;

public class ItemTransactionDTO {

	private int invNo;
	private int itemNo;
	private int qty;
	
	@Override
	public String toString() {
		return "ItemTransactionDTO [invNo=" + invNo + ", itemNo=" + itemNo + ", qty=" + qty + "]";
	}
	public final int getInvNo() {
		return invNo;
	}
	public final void setInvNo(int invNo) {
		this.invNo = invNo;
	}
	public final int getItemNo() {
		return itemNo;
	}
	public final void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public final int getQty() {
		return qty;
	}
	public final void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
