package Day16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class iNetDemo {

	public static void main(String[] args) throws Exception {
		InetAddress ineta = InetAddress.getByName("www.google.com");
		
		//to get the ip address - shows the main server
		System.out.println(ineta.getHostAddress());
		System.out.println(ineta.getHostName());
		
		//to get the address when connected with multiple servers
		
		InetAddress inetarra[] = InetAddress.getAllByName("www.irctc.co.in");
		for(InetAddress a:inetarra)
		  System.out.println(a.getHostAddress());
		
		//given a ip address we have to get the host name also...
		
	}
}
