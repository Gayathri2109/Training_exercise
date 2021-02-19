package day1;

import java.util.Scanner;

public class Calender {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n;
	n = s.nextInt();
	Feb f = new Feb();
	
	switch(n)
	{
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12: System.out.print("31 days ");
			 break;
	case 4:
	case 6:
	case 9:
	case 11: System.out.print("30 days ");
			 break;
	case 2: f.met();
	        break;
	default: System.out.println("Case did not match");
	
	
	}
}
}

class Feb{
	public void met()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the year..");
		int year;
		year = s.nextInt();
		boolean leap = false;
		
		if(year%4 == 0)
		{
			if(year%100 == 0)
			{
				if(year%400 == 0)
				{
					leap = true;
				}
				else
					leap = false;
				
			}
			else
				leap = true;
		}
		else
			leap = false;
		
		if(leap == true)
			System.out.println("It's a leap year, so 29 days in a month");
		else
			System.out.println("It's not a leap year, so 28 days in a month");
		
	}
}
