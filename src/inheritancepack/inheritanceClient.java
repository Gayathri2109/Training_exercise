package inheritancepack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class inheritanceClient {

	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		ShoeFactory factory = new ShoeFactory();
		factory.setName("Parent Name....");
		
		BataShoeFactory bsf = new BataShoeFactory();
		bsf.setName("Parent Name....BATA...");
		bsf.setBataName("bata bata bata.....");
		
		LakhaniShoeFactory lsf = new LakhaniShoeFactory();
		lsf.setName("Parent Name....LAKHANI...");
		lsf.setLakhaniName("lakhani lakhani lakhani.....");
		
		session.save(factory);
		session.save(bsf);
		session.save(lsf);
		session.beginTransaction().commit();
	}
}
