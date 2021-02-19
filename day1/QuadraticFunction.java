package day1;

public class QuadraticFunction {

	public static void main(String[] args) {
		Function f = new Function(2,2,2);
		System.out.println(f.Compute(1));
		
	}
}

class Function
{
	int a,b,c;
	Function()
	{
		a = b = c =1;
	}
	
	Function(int a,int b,int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int A1(){
		return a;
	}
	
	public int B1(){
		return b;
	}
	
	public int C1(){
		return c;
	}
	
	public int Compute(int x)
	{
		int tot;
		tot = (a*x*x)+(b*x)+c;
		return tot;
	}
}
