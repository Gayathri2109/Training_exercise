package Day11.Day4ExceptionHandling;

public class Q3 {
	public static void main(String[] args) {
		Test1 s = new Test1();
		s.mth1();
	}
	
}

class Test1{

	public void mth1()
	{
		mth2();
		System.out.println("Caller");
	}
	public void mth2()
	{
		try {
			System.exit(0);
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