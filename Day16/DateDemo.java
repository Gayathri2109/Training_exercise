package Day16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateDemo {

	public static void main(String[] args) {
		LocalDateTime currtime = LocalDateTime.now();
		System.out.println(currtime);
		
		//to pick up the date
		LocalDate date = currtime.toLocalDate();
		System.out.println(date);
		
		//to pick up the time
		LocalTime time =currtime.toLocalTime();
		System.out.println(time);
		
		Month month = currtime.getMonth();
//		System.out.println(month);
		int year = currtime.getYear();
		int day = currtime.getDayOfMonth();
		int hr = currtime.getHour();
		int min = currtime.getMinute();
		int sec = currtime.getSecond();
		
		System.out.println(day+"/"+month.getValue()+"/"+year);
		System.out.println(hr+":"+min+":"+sec);
		
		LocalDate customDate = LocalDate.of(2018, Month.DECEMBER, 21);
		System.out.println(customDate.getDayOfMonth());
		
		LocalTime customTime = LocalTime.of(2,20,15);
		System.out.println(customTime);
		
		
		
		LocalDate nextC = customDate.plus(1,ChronoUnit.CENTURIES);
		System.out.println(nextC);
	
		LocalTime nextTime = customTime.plus(1,ChronoUnit.HOURS);
		System.out.println(nextTime);
		
		LocalTime parseTime = LocalTime.parse("02:15:30");
		System.out.println(parseTime);
		
		ZonedDateTime internationalTime = ZonedDateTime.now();
		System.out.println(internationalTime);
		
		ZonedDateTime ktime = ZonedDateTime.parse("2021-03-09T13:55:54.138767300+05:30[Asia/Karachi]");
	
		System.out.println(ktime);
	}
	
}
