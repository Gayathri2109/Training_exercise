package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	Socket s;
	BufferedReader br,in;
	PrintWriter out;
	
	
	
	public Client() throws Exception, IOException {
		
		while(true) {
		s = new Socket("localhost",2000);
		
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String msg = br.readLine();
		System.out.println("Message from server...."+msg);
	
		System.out.println("Enter a msg to the server.....");
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(s.getOutputStream(),true);
		String str = in.readLine();
		out.println(str);
	}
}
	public static void main(String[] args) throws Exception {
		new Client();
	}
}
