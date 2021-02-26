package Day9.FridayFun;

public class Q38 {
public static void main(String[] args) {
	int a =0;
	int j =1;
	int sum = 0;
	System.out.print(a+" "+j+" ");
	for(int i=0;i<10;i++)
	{
		
		sum = a+j;
		System.out.print(" "+sum+" ");
		a = j;
		j = sum;
	}
}
}
