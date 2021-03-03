package Day12_MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {
public static void main(String[] args) {
	ExecutorService es;
	es = Executors.newFixedThreadPool(2);
	
	Frog frog = new Frog();
	Crane crane = new Crane();
	
	es.execute(()->{
		crane.eat(frog);
	});
	
	es.execute(()->{
		frog.escape(crane);
	});
	
	es.shutdown();
	
	
}
}

class Crane{
	synchronized public void eat(Frog frog)
	{
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {}
		frog.LeaveCrane();
		System.out.println("The end...");
	}
	synchronized public void spitFrog()
	{
		System.out.println("Spit me...");
	}
}

class Frog{
	synchronized public void escape(Crane crane)
	{
		crane.spitFrog();
		
	}
	
	synchronized public void LeaveCrane()
	{
		System.out.println("Leave me....");
	}
}