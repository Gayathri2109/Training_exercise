package Day11.Day4ExceptionHandling;

import java.io.IOException;
import java.util.Scanner;

public class Q9 {
public static void main(String[] args) throws Custom {
	
	System.out.println("Before Exception...");
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	
	try {
		if(n<0 ||n>100)
			throw new Custom("Do enter the values within the range 0 to 100...");
	}
	
	catch(Exception e)
	{
		System.out.println(e);
		//System.out.println("Do enter an integer value");
	}
	System.out.println("After Exception...");
 }
}

class Custom extends IOException{
	String str;
	public Custom(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		return this.str;
	}
}