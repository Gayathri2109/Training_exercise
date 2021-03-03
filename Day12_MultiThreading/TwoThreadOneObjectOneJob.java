package Day12_MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadOneObjectOneJob {
public static void main(String[] args) {
	ExecutorService es = Executors.newFixedThreadPool(2);
	Gun gun = new Gun();
	es.execute(()->{
		for(int i=0;i<5;i++)
		gun.fillGun();
	});
	
	es.execute(()->{
		for(int i=0;i<5;i++)
		gun.shootGun();
	});
}
}

class Gun{
	boolean flag;
	synchronized public void fillGun() 
	{
		if(flag)
		{
			try{
				wait();
			}catch(Exception e) {}
		}
		System.out.println("Fill the Gun...");
		flag = true;
		notify();
	}
	
	synchronized public void shootGun()
	{
		if(!flag) {
			try{
				wait();
			}catch(Exception e) {}
		}
		System.out.println("Shoot now...");
		flag = false;
		notify();
	}
}
