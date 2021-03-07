package CollectionsTest;

import java.util.HashMap;
import java.util.Map;

public class Q4 {

	private Map<String,Integer> accountTotals = new HashMap<String,Integer>();
    private int retirementFund;

 public int getBalance(String accountName) {
	 Integer total = (Integer) accountTotals.get(accountName);
	 if (total == null)
		 total = Integer.valueOf(0);
	 return total.intValue();
 }
 
 public void setBalance(String accountName, int amount) {
	 	accountTotals.put(accountName, Integer.valueOf(amount));
 		}
 
 public static void main(String[] args) {
	 Q4 q = new Q4();
	 q.setBalance("Gayu", 1000);
	 q.setBalance("darshu", 5000);
	 System.out.println(q.getBalance("Gayu"));
	 System.out.println(q.getBalance("Darshu"));
  }
 }