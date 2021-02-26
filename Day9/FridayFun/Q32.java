package Day9.FridayFun;

import java.util.Scanner;

public class Q32 {
public static void main(String[] args) {
	int prime;
	Scanner s = new Scanner(System.in); 
	prime = s.nextInt();
	
	if(prime==0 || prime==1)
		System.out.println("Not an Prime No");
	else if(prime(prime))
		System.out.println("Prime No");
	else
		System.out.println("Not an prime no");
}

public static boolean prime(int i)
{
	int j =2;

	while(j<=i/2) {
	
		if(i%j == 0)
			return false;
		j++;
	}
	
	return true;
}
}
