package Day9.FridayFun;

import java.util.Scanner;

public class Q29 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	char c;
	c  = scan.next().charAt(0);
	
	switch (c)
	{
	case 'a':
	case 'e':
	case 'i':
	case 'o':
	case 'u':
	case 'A':
	case 'E':
	case 'I':
	case 'O':
	case 'U': System.out.println("It's a vowel");
	        break;
	default: System.out.println("It's not a vowel");
		
	}
	
	
}
}
