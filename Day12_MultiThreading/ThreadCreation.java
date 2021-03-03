package Day12_MultiThreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCreation {
	
	public ThreadCreation() {
//		Thread t = new Thread(new ThreadJob());
//		t.start();
		
		ExecutorService es;
		es= Executors.newFixedThreadPool(1);
//		es.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Anonmyous Inner class...");
//				
//			}
//		});
		
		es.execute(()->{
			System.out.println("Lamda Child Wroking...");
		});
		
		es.shutdown();
		//es.execute(new ThreadJob());
	}
public static void main(String[] args) throws Exception {

		new ThreadCreation();
		for(int i=1;i<6;i++)
		{
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
}

class ThreadJob implements Runnable{
	public void run() {
		System.out.println("Child Working...");
	}
}
	


