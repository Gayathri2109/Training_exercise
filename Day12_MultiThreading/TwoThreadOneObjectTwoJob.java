package Day12_MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadOneObjectTwoJob {
	public static void main(String[] args) {
			ExecutorService es=Executors.newFixedThreadPool(2);
			ReservationCounter central=new ReservationCounter();
			es.execute(()->{
				Thread.currentThread().setName("ramu");
				synchronized(central)
				 {
				 central.bookTicket(1000);
				 central.giveChange();
				 }
				 });
				 es.execute(()->{
				 Thread.currentThread().setName("somu");
				 synchronized(central)
				 {
				 central.bookTicket(500);
				 central.giveChange();
				 }
				 central.drinkWater();
				 });
				 es.shutdown();
		 }
	} 

class ReservationCounter{
	int amt; 
	public void bookTicket(int amt) {
		 this.amt=amt;
		 Thread t=Thread.currentThread();
		 String name=t.getName();
		 System.out.println("Ticket booked by...:"+name+" with amount....:"+amt);
		 System.out.println("sleeping....:"+name);
		 try {Thread.sleep(1000);}catch(Exception e) {}
		 }

		//synchronized
	public void giveChange() {
		 Thread t=Thread.currentThread();
		 String name=t.getName();
		 System.out.println("Change given to...:"+name+" amount is...:"+(amt-100));
		 }
	synchronized public void drinkWater() {
		 System.out.println("Drinking water................."+Thread.currentThread().getName());
	 }
} 

