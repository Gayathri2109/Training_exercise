package Services;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class AppLoader {
	
	public static void main(String[] args)throws Exception {
		System.out.println("Started......");
		Serverimpl is=new Serverimpl();
		
		LocateRegistry.createRegistry(1099);
		
		Naming.bind("rmi://localhost:1099/appLoader", is);
		
		System.out.println("Invoice app ready...");
	}
}