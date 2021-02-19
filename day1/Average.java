package day1;

public class Average {
	public static void main(String[] args) {
		Ave obj = new Ave();
		float n =obj.met(1,2,3,4,5);
		System.out.println("Average of nos..."+n);
		}
}

class Ave
{
	public float met(int...i)
	{
		int sum = 0;
		int c=0;
		for(int x: i)
		{
			sum = sum+x;
			c++;
		}
		float r = sum/c;
		return r;
	}
}