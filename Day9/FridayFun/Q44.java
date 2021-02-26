package Day9.FridayFun;

public class Q44 {
	public static void main(String[] args) {
		int  a[] = {10,20,30};
		int b[] = {100,200,300};
		
		if(a.length == b.length) {
		System.out.println("Before Swaping");
		
		System.out.println("Value of arr a: ");
		for(int i=0;i<a.length;i++)
		    System.out.print(a[i]+" "); 
		System.out.println("\nValue of arr b: ");
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]+" ");
		for(int i=0;i<b.length;i++) {
		a[i] = a[i] +b[i];
		b[i] = a[i]-b[i];
		a[i] = a[i]-b[i];
		}
		System.out.println("\nAfter Swaping");
		System.out.println("Value of arr a: ");
		for(int i=0;i<a.length;i++)
		    System.out.print(a[i] + " "); 
		System.out.println("\nValue of arr b: ");
		for(int i=0;i<b.length;i++)
			System.out.print(b[i] + " ");
		
	}}
}
