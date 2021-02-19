package day1;

import java.util.Scanner;

public class Numbers {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n;
	n = s.nextInt();
	Main obj = new Main();
	int x = obj.ArmstrongNo(n);
	int y = obj.Palindrome(n);
	int z = obj.Perfect(n);
	if(x==1)
	    System.out.println("It's a armstrong no.");
	if (y==1)
		System.out.println("It's a palindrome no.");
	if(z==1)
		System.out.println("It's a perfect no.");
	
}
}

class Main{
	public int ArmstrongNo(int n)
	{
		int c = 0;
		int a;
		int temp = n;
		
		
		while(n>0)
		{
			a = n%10;
			c = c + (a*a*a);
			n = n/10;
		}
		if( temp == c)
			return 1;
		else
			return 0;
	}
	
	public int Palindrome(int n)
	{
		int temp,tot = 0;
		int num = n;
		
		while(num!=0)
		{
			temp = num%10;
			tot = (tot*10) + temp;
			num = num/10;
		}
		
		if(tot == n)
			return 1;
		else
			return 0;
	}
	
	public int Perfect(int n)
	{
		int sum =0;
		for(int i=1;i<n;i++)
		{
			if(n%i==0)
			{
				sum = sum + i;
			}
		}
		if(sum == n)
			return 1;
		else
			return 0;
		
	}
}
