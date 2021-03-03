package Day12_MultiThreading;

public class Basic {
public static void main(String[] args)  {
	
	System.out.println("First Line....");
	//method();
//	new Thread(new Runnable() {
//		
//		@Override
//		public void run() {
//			method();
//			
//		}
//	}).start();
	
	new Thread(()->{
		method();
	});
	
	System.out.println("Third Line....");
}

public static void method()
{
	try{
		Thread.sleep(1000);
	}
	catch(Exception e) {}
	System.out.println("Second Line....");
}
//	
//	public static void main(String[] args) throws Exception {
//		Thread t = Thread.currentThread();
//		t.setName("Gayu");
//		System.out.println("Hello...curr thread...");
//		Thread.sleep(1000);
//		System.out.println(t);
//		
//	}
}


