package Day11.Day4ExceptionHandling;

import java.util.Scanner;

public class Q7 {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	String num;
	String den;
	int result;
	
		do{
			System.out.println("Enter the numerator and divisor...");
			num = s.next();
			den = s.next();
			
			try {
				result = Integer.parseInt(num)/Integer.parseInt(den);
				System.out.println("Result..."+result);
		        }
			catch(ArithmeticException ae) {
			System.out.println("Enter the denominator no greater than zero...");
			}
			catch(NumberFormatException ne) {
				if(num.charAt(0)=='q' || num.charAt(0)=='Q')
					System.exit(0);
				System.out.println("Enter a valid Input...");
			}
	
		}while(true);
	}
}
