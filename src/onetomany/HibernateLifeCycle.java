package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class HibernateLifeCycle {

	public static void main(String[] args) {
		
		
		Session session = HibernateUtility.getSession();
		
		//Transient state....
		Employee emp = new Employee();
	
		emp.setEmpname("Gayuu");
		emp.setEmpsal(200000);
		
		Address ad1 = new Address();
		ad1.setCity("Chennai");
		ad1.setStreet("Anna nagar street");
		ad1.setEmp(emp);
		
		Address ad2 = new Address();
		ad2.setCity("Coimbatore");
		ad2.setStreet("Kuniyamuthur street");
		ad2.setEmp(emp);
		
		Set<Address> set = new HashSet<Address>();
		set.add(ad1);
		set.add(ad2);
		
		emp.setAddresses(set);
		
		//Persistant state...
		session.save(emp);
		emp.setEmpname("Darshu");
		
		HibernateUtility.closeSession(null);
		
	}
}
