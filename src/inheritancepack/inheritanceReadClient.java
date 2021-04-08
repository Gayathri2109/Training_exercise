package inheritancepack;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtility;


public class  inheritanceReadClient{
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		Query query=session.createQuery("from ShoeFactory");
		
		//List<ShoeFactory> list=query.list();
		
		Iterator<ShoeFactory> iter = query.iterate();
		
		
		
		while(iter.hasNext()) {
		
			ShoeFactory factory = iter.next();
			factory.visit();
		
		}
		
	}
}