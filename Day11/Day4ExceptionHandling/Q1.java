package Day11.Day4ExceptionHandling;

import java.io.IOException;

public class Q1 {
	public static void main(String[] args) {
		Test obj = new Test();
		System.out.println("Before Exception...");
		try {
			obj.method();
		}
		catch(CustomException e)
		{
			System.out.println(e);
		}
		
		System.out.println("After Exception...");
}}

class Test{
	

	public void method() throws CustomException
	{
	throw new CustomException("throwing an object of class IO Exception...");
	}
}
	

class CustomException extends IOException
{
	String str;
	public CustomException(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return "Exception.....:"+this.str;
	}
}
	
