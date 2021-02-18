package day3;

public class MethodDemo {
	int i=1;
	float f=1.1f;
	double d=2.2;
	String s="hello";
	char c='a';
	boolean b=true;
	
	public static void main(String[] args) {
		MethodDemo obj=new MethodDemo();
		obj.met(1);
		obj.met(1,2,3,4,5);
		String s = "World";
		System.out.println(obj.print(s));
	}
	
	public int met(int i)
	{
		System.out.println("ordinary is called");
		return 1;
	}
	
	public int met(int... i)
	{
		System.out.println("... is called");
		return 1;
	}
	
	public String print(String s)
	{
		return "Hello.."+s;
	}
	
	public Hai pri()
	{
		return new Hai();
	}
}
class Hai
{
	
}

