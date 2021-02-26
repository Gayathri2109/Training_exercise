package Day9.FridayFun;

import java.util.Scanner;

public class Q28 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int i;
	while(true) {
	System.out.println("Enter the month to know the season...");
	i = scan.nextInt();
	if( i>=3 && i<=5)
		System.out.println("Summer Season");
	else if(i== 12 || i ==1 || i == 2)
		System.out.println("Winter Season");
	else if(i==10 || i==11)
		System.out.println("Autmn Season");
	else if(i>=6 && i<=9)
		System.out.println("Rainy Season");
	
}
}}
