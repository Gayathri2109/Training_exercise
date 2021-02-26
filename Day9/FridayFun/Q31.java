package Day9.FridayFun;

import java.util.Scanner;

public class Q31 {
public static void main(String[] args) {
	int a = 10;
	int b = 10;
	int i;
	Scanner scan = new Scanner(System.in);
	System.out.println("Press \n1 for additon\n2 for sub\n3 for multiply\n4 for division");
	i = scan.nextInt();
	switch (i)
	{
	case 1:
		System.out.println("Addition=" + ((int)a+b));
		break;
	case 2:
		System.out.println("subraction= "+ (a-b));
		break;
	case 3:
		System.out.println("Multiplication= "+ a*b);
		break;
	case 4:
		System.out.println("Division= "+ a/b);
		break;
	default:
		 System.out.println("No case found for your choice....");
}
}}
