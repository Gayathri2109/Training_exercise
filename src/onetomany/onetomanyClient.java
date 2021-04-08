package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class onetomanyClient {

	public static void main(String[] args) {
		
		Session session = HibernateUtility.getSession();
		
		Employee emp = new Employee();
		emp.setEmpname("rrrramu");
		emp.setEmpsal(20000);
		
		Address ad1 = new Address();
		ad1.setCity("Chennai");
		ad1.setStreet("mg street");
		ad1.setEmp(emp);
		
		Address ad2 = new Address();
		ad2.setCity("Coimbatore");
		ad2.setStreet("kg street");
		ad2.setEmp(emp);
		
		Set<Address> set = new HashSet<Address>();
		set.add(ad1);
		set.add(ad2);
		
		emp.setAddresses(set);
		
		session.save(emp);
		//session.save(ad1);
		//session.save(ad2);
		
		HibernateUtility.closeSession(null);
		
		
	}
}
