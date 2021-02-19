package day1;

import java.util.Scanner;

public class Prime {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n;
	n = s.nextInt();
	
	PrimeNos obj =new PrimeNos();
	int x = obj.met1(n);
	if(x==1)
		System.out.println(n+" is a Prime no");
	else
		System.out.println(n+" is a not a Prime no");
	
	System.out.println("Prime nos from 1 to 100....");
	obj.met2();
	
	}
}

class PrimeNos
{
	public int met1(int n)
	{
		boolean b = false;
		for(int i=2;i<=n/2;i++)
		{
			if(n%i==0)
			{
				b = true;
				break;
			}
		}
		
		if(!b)
			//System.out.println(n+" is a Prime no");
		  return 1;
		else
			//System.out.println(n+ " is not a Prime no");
			return 0;
		
	}
	
	
	public void met2()
	{
		
		for (int i=1;i<=100;i++)
		{
			int n = met1(i);
			if(n==1)
				System.out.print(i+ " ");
				
		}
	}
	
	
}
