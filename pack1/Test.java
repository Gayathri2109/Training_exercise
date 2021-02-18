package pack1;

public class Test {
public static void main(String[] args) {
	System.out.println("Welcome to Java");
}
}

class Sample{
	private 	int s1;
				int s2;
	protected 	int s3;
    public 		int s4;
	
    public void sum()
	{
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}

class Task extends Sample
{
	public void sum()
	{
		//System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
	
}

class Task2
{
	Sample s = new Sample();
	public void sum()
	{
		//System.out.println(s.s1);
		System.out.println(s.s2);
		System.out.println(s.s3);
		System.out.println(s.s4);
	}
	
}

