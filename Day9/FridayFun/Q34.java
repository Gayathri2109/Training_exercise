package Day9.FridayFun;

public class Q34 {
public static void main(String[] args) {
	int i = 1;
	int sum = 0;
	int avg;
	int count = 0;
	while(i<=10)
	{
		sum = sum + i;
		count++;
		System.out.println(i+" ");
		i = i+2;
		
	}
	avg = sum/count;
	System.out.println(count+ " "+ sum);
	System.out.println("Average of odd Nos: "+avg);
	
 }
}
