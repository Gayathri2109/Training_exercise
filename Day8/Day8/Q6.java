package Day8;

public class Q6 {
	
	static
	{
		System.out.println("Static Block...");
	}
	public static void main(String[] args) {
	
		get();
		System.out.println("Main Block....");
		
     }
	public static void get()
	{
		System.out.println("Local method block...");
	}
}
