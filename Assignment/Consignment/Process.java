package Consignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Process {

	private static Process p;
	private Process() {
		// TODO Auto-generated constructor stub
	}
	public void getFinalDate(LocalTime time,LocalDate date,int d) {
		int travelSpeed = 10; //km/hr (assumption)... 
		int hr,distance;
		long days;
		
		distance = d;
		hr = distance/travelSpeed;
		System.out.println();
		days = (long)(hr*0.041667);
	
		LocalTime customtime = time.plusHours(hr);
		
		LocalDate customDate = date.plusDays(days);//date.plusDays(days);
		
		int h = customtime.getHour();
		int m = customtime.getMinute();
		
		System.out.print("\nThe parcel will reach u on "+customDate);
		System.out.printf("at the time of %d:%d",h,m);
		System.out.println("\nPlease make yourself available...Thank You....");
	}
	
	public static Process getObj() {
		
		if(p==null)
			return new Process();
		return p;
	}
}




