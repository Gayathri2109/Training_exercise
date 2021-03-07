package CollectionsTest;

import java.util.HashMap;
import java.util.Map;

public class Q29 {

	// private Map accountTotals = new HashMap();
	private Map<String, Integer> accountTotals = new HashMap<String, Integer>(); 
	//private int retirementFund;

	 public int getBalance(String accountName) {
		 Integer tot = accountTotals.get(accountName);
		 if(tot==null)
			 tot = 0;
		 return tot;
	 }
	 
	 public void setBalance(String accountName, int amount) {
		 accountTotals.put(accountName, amount);
	 }
	 
	 public static void main(String[] args) {
		Q29 q = new Q29();
		q.setBalance("Gayu", 1000);
		q.setBalance("darshu", 500);
		
		System.out.println(q.getBalance("gayu"));
		System.out.println(q.getBalance("darshu"));
	}
 }