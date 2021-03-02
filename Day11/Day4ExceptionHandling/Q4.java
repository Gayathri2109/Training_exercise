package Day11.Day4ExceptionHandling;

public class Q4 {
public static void main(String[] args) {
	System.out.println("Before.....");
	try {
		throw new CustomException1("Exception thrown");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	System.out.println("After....");
}
}

class CustomException1 extends Exception{
	
	String msg;
	public CustomException1(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return this.msg;
	}
}
