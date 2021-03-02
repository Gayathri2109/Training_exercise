package Day11.Day4ExceptionHandling;

public class Q2 {

	
	public static void main(String[] args) {
		Q2 s = new Q2();
		s.mth1();
	}
	
	public void mth1()
	{
		mth2();
		System.out.println("Caller");
	}
	public void mth2()
	{
		try {
			int i = 1/0; //statement for catching the exception...
			return;
		}
		catch(Exception e)
		{
			System.out.println("Catch-mth2");
		}
		finally {
			System.out.println("Finally-meth2");
		}
		
	}
	
}