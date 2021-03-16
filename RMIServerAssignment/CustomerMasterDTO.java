package Assignment;

import java.io.Serializable;

public class CustomerMasterDTO implements Serializable{

	private int custNo;
	private String custName;
	private String custAddress;
	private String custEmail;
	private String custPhone;
	public final int getCustNo() {
		return custNo;
	}
	public final void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	public final String getCustName() {
		return custName;
	}
	public final void setCustName(String custName) {
		this.custName = custName;
	}
	public final String getCustAddress() {
		return custAddress;
	}
	public final void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public final String getCustEmail() {
		return custEmail;
	}
	public final void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public final String getCustPhone() {
		return custPhone;
	}
	public final void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	@Override
	public String toString() {
		return "custNo=" + custNo + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custEmail=" + custEmail + ", custPhone=" + custPhone;
	}
	
}
