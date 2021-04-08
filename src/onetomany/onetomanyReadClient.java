package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class onetomanyReadClient {

	public static void main(String[] args) {
		
		Session session = HibernateUtility.getSession();
		
		Employee emp = (Employee)session.get(Employee.class, Integer.valueOf(1));
		
		System.out.println(emp.getEmpname());
		
		HibernateUtility.closeSession(null);
		
		
	}
}
