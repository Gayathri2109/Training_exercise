package model;

import java.io.Serializable;

public class CustomerMasterDTO implements Serializable{

	private int custNo;
	private String custName;
	private String custAddress;
	private String custEmail;
	private String custPhone;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custAddress == null) ? 0 : custAddress.hashCode());
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + custNo;
		result = prime * result + ((custPhone == null) ? 0 : custPhone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMasterDTO other = (CustomerMasterDTO) obj;
		if (custAddress == null) {
			if (other.custAddress != null)
				return false;
		} else if (!custAddress.equals(other.custAddress))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custNo != other.custNo)
			return false;
		if (custPhone == null) {
			if (other.custPhone != null)
				return false;
		} else if (!custPhone.equals(other.custPhone))
			return false;
		return true;
	}
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
