package Day9.FridayFun;

public class Q4 {
public static void main(String[] args) {
	String s = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
	met(s);
}

public static void met(String s)
{
	char a[] = s.toCharArray();
	int space = 0;
	int let = 0;
	int other = 0;
	int num =0;
	
	for(int i=0;i<a.length;i++)
	{
		if(Character.isAlphabetic(a[i]))
			let++;
		else if(Character.isDigit(a[i]))
			num++;
		else if(Character.isSpaceChar(a[i]))
			space++;
		else
			other++;
	}
	
	System.out.println("The string is : Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33");     
	System.out.println("letter: " + let);
	System.out.println("space: " + space);
	System.out.println("number: " + num);
	System.out.println("other: " + other);
	} 
}

