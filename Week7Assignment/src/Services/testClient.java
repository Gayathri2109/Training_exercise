package Services;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class testClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException  {
		
		System.out.println("Client started.....");
		Server s = (Server)Naming.lookup("rmi://localhost:1099/appLoader");
		//Server s = new Serverimpl();
		s.getServer();
		
	}
}
