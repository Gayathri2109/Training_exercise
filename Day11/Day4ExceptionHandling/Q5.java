package Day11.Day4ExceptionHandling;

public class Q5 {

	public static void method() throws CustomException1
	{
		try {
		throw new CustomException1("Exception thrown");}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws CustomException1 {
		Q5.method();
	}
}
