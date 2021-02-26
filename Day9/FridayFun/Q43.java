package Day9.FridayFun;

public class Q43 {
public static void main(String[] args) {
	int a[]= {42,535,900,4,5,65,99,43};
	int low = a[0];
	int high = a[0];
	for(int i=1;i<a.length;i++)
		if(low>a[i])
			low = a[i];
		else if(high<a[i])
			high = a[i];
	System.out.println("Low: "+low+"\nHigh: "+high);
	
	
}
}
