package day1;

public class NoToWords {

	public static void main(String[] args) {
		int n = 230;
		int num = n;
		int temp=0;
		int tot =0;
		while(num!=0)
		{
			temp = num%10;
			tot = tot*10 + temp;
			num = num/10;
		}
		
		int x = tot;
		int val =0;
		System.out.print("The no "+n+" in words.....");
		while(x!=0)
		{
			val = x%10;
				
			switch(val)
		{
		case 0: System.out.print("zero ");
				break;
		case 1: System.out.print("One ");
				break;
		case 2: System.out.print("two ");
				break;
		case 3: System.out.print("three ");
				break;
		case 4: System.out.print("four ");
				break;
		case 5: System.out.print("five ");
				break;
		case 6: System.out.print("six ");
				break;
		case 7: System.out.print("seven ");
				break;
		case 8: System.out.print("eight ");
				break;
		case 9: System.out.print("nine ");
				break;
		
		}
			x = x/10;
			
		}
		
		if(n%10 == 0)
			System.out.println("zero");
		
		
		
	}
}
