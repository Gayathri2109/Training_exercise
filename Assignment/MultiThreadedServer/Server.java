package MultiThreadedServer;


//Private Chat with the Clients....
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	ServerSocket ss;
	Socket s;
	
	public Server() throws Exception {
		
		
		ss = new ServerSocket(2000);
		ss.setReuseAddress(true);
		System.out.println("Ready....");	
		while(true) {
		
			s = ss.accept();
			//System.out.println(s);
			ClientHandler client = new ClientHandler(s);
			//new Thread(client).start();;
			ExecutorService es = Executors.newFixedThreadPool(1);

			es.execute(client);
		
	     }
}
	
	public static void main(String[] args) throws Exception {
		new Server();
	}
}

class ClientHandler implements Runnable{
	
	Socket s;
	PrintWriter out;
	BufferedReader br,in;
	
	public ClientHandler(Socket s) {
		this.s = s;		
	}

	@Override
	public void run() {
		
		
		System.out.println("Enter a msg to the client.....");
		in = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		try {
			str = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(s.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println(str);
		
	
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = null;
		try {
			msg = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Message from Client...."+msg);
		
	}
}
