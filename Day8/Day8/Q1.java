package Day8;
//Core Java Exercise module 2,3 (Inheritance)

public class Q1 {
public static void main(String[] args) {
	Primitive pri = new Primitive();
	
	System.out.println("Pass By Value:");
	System.out.println("Value of i before passing: "+ pri.i);
	pri.change1(5);
	System.out.println("Value of i after passing: "+ pri.i+"\n");
	
	System.out.println("Pass By Reference:");
	System.out.println("Value of i before passing: "+ pri.i);
	pri.change2(pri);
	System.out.println("Value of i after passing: "+ pri.i);

	
	int a[] = new int[2];
	a[0] = 1;
	a[1] = 2;
	
	System.out.println("\nTo show Arrays are pass by value");
	Arrays arr = new Arrays();
	System.out.println("Values before passing: "+ a[0] +","+ a[1]);
	arr.change(a);
	System.out.println("Values after passing: "+ a[0] +","+ a[1]);
}
}

class Primitive{
	
	int i =5;

	public void change1(int i)
	{
		i = i + 10;
	}
	
	public void change2(Primitive pri)
	{
		pri.i = pri.i + 10;
	}
	
}

class Arrays{

	public void change(int a[])
	{
		a[0] = 10;
		a[1] = 15;
	}
	
}
