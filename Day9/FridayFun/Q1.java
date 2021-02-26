package Day9.FridayFun;

public class Q1 {
public static void main(String[] args) {
	int  a = 10;
	int b = 20;
	System.out.println("Before Swaping");
	System.out.println("Value of a: "+ a + "\nValue of b: "+ b);
	a = a+b;
	b = a-b;
	a = a-b;
	System.out.println("\nAfter Swaping");
	System.out.println("Value of a: "+ a + "\nValue of b: "+ b);
}
}

