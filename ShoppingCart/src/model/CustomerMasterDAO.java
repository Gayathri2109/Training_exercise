package model;

import java.util.Set;


public interface CustomerMasterDAO {

	public int insertCustomer(CustomerMasterDTO custMasterDTO);
	public int deleteCustomer(int custNo);
	public int updateCustomer(CustomerMasterDTO custMasterDTO);
	public CustomerMasterDTO getCustomerMaster(String custName);
	public CustomerMasterDTO getCustomerMaster(int custNo);
	public Set<CustomerMasterDTO> getCustomerMasterAll();
}
