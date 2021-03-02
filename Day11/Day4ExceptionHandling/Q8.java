package Day11.Day4ExceptionHandling;


public class Q8 {
	public static void main(String[] args) {
		
		System.out.println("Before Exception...");
		try {
			
			int n = Integer.parseInt(null);
		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("Do enter an integer value");
		}
		System.out.println("After Exception...");
	}
}