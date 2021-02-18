package day3;

public class Static {

	public static void main(String[] args) {
		//Sample s =Sample.Connection();
		Sample.method1();
		Sample.method2();
	}
}


class Sample
{
	private Sample()
	{
		System.out.println("Constructor is called.......");
	}
	
	static {
		System.out.println("static block is called");
	}
	
	public static Sample Connection()
	{
		return new Sample();
	}
	
	public static void method1()
	{
		System.out.println("method1 is called.....");
	}
	
	public static void method2()
	{
		System.out.println("method2 is called....");
	}
}
