package Consignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//import java.util.Scanner;

public class User {

	private static User u;
	public static void main(String[] args) {
		//Order o = new Order();
		Scanner scan = new Scanner(System.in); 
		final String str;
		int i;
		int distance;
		
		User u = User.getObj();
		u.getItem();
		i = scan.nextInt();
		System.out.println("Enter your location...");
		str = scan.next();
		System.out.print("Order placed Successfully on ");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		int hr = time.getHour();
		int min = time.getMinute();
		
		System.out.print(date+" at ");
		System.out.printf("%d:%d",hr,min);
		
		distance = u.getDistance(str);
		//System.out.println(distance);
		Process p = Process.getObj();
		
		p.getFinalDate(time,date,distance);
   }
	
	public void getItem() {
		//sample item...
		System.out.println("WELCOME....");
		System.out.println("Items:\n1.Latptop\n2.IPhone\n3.Hardisk\nPress the item no which u want to place the order for.");
		
	}
	
	public static User getObj()
	{
		if(u==null)
		 return new User();
		return u;
	}
	
	public int getDistance(String str) {

		int distance = 0;
		//sample distances...
		//System.out.println(str);
		if(str.equalsIgnoreCase("Salem"))
			distance = 340; //km
		else if(str.equalsIgnoreCase("Coimbatore"))
			distance = 480; //km
		else if(str.equalsIgnoreCase("chennai"))
			distance = 10; //assuming to be 10km inside chennai....
		
		return distance;
	}
}


