package Day9.FridayFun;

public class Q37 {
public static void main(String[] args) {
	int i = 12345;
	int a = i;
	int sum = 0;
	int tot;
	while(a!=0)
	{
		tot = a%10;
		sum = sum + tot;
		a = a/10;
	}
	System.out.println(sum);
}
}
