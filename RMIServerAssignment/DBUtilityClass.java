package Assignment;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBUtilityClass {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.execute(()->{	
			try {
				Set<ItemMasterDTO> set;
				ItemMasterDAOimpl obj = new ItemMasterDAOimpl(Assignment.DBUtility.getConnection());
				set = obj.getItemMasterAll();
				System.out.println(set);
				DBUtility.closeConnection(null);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		es.execute(()->{
			
			Set<CustomerMasterDTO> set1;
			CustomerMasterDAOimpl obj1;
			try {
				obj1 = new CustomerMasterDAOimpl(Assignment.DBUtility.getConnection());
				set1 = obj1.getCustomerMasterAll();
				System.out.println(set1);
				DBUtility.closeConnection(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		es.execute(()->{
		
			try {
			Set<InvoiceMasterDTO> set2;
			InvoiceMasterDAOImpl obj2 = new InvoiceMasterDAOImpl(Assignment.DBUtility.getConnection());
			set2 = obj2.getInvoiceMasterAll();
			System.out.println(set2);
			DBUtility.closeConnection(null);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		});
		
		es.execute(()->{
			
			try {
			Set<ItemTransactionDTO> set3;
			ItemTransactionDAOimpl obj3 = new ItemTransactionDAOimpl(Assignment.DBUtility.getConnection());
			set3 = obj3.getItemMasterAll();
			System.out.println(set3);
			Assignment.DBUtility.closeConnection(null);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		});
	
		
	}
}
