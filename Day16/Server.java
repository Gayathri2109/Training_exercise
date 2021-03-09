package Day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket ss;
	Socket s;
	PrintWriter out;
	BufferedReader br,in;
	
	public Server() throws Exception {
		ss = new ServerSocket(2000);
		System.out.println("Ready....");
		
		while(true) {
		s = ss.accept();
		System.out.println(s);
		
	
		System.out.println("Enter a msg to the client.....");
		in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		out = new PrintWriter(s.getOutputStream(),true);
		out.println(str);
		
	
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String msg = br.readLine();
		System.out.println("Message from Client...."+msg);
	}
}
	
	public static void main(String[] args) throws Exception {
		new Server();
	}
}
