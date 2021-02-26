package Day9.FridayFun;

public class Q36 {
public static void main(String[] args) {
	String str = "mom";
//	StringBuilder obj = new StringBuilder();
//	obj.append(str);
//	obj.reverse();
	String rev = "";
	for(int i=str.length()-1;i>=0;i--)
		rev = rev + str.charAt(i);
	//System.out.println(rev);
	if(str.equals(rev))
		System.out.println("Palindrome");
	else
		System.out.println("Not an Palindrome");
	
	int i = 121;
	int a = i;
	int sum = 0;
	int tot;
	while(a!=0)
	{
		tot = a%10;
		sum = sum*10 + tot;
		a = a/10;
	}
	if(sum == i)
		System.out.println("Palindrome no");
	else
		System.out.println("Not an Palindrome no");
	
}
}
