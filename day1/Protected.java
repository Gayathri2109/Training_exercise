package day1;

public class Protected {

	protected int n = 5;
	public static void main(String[] args) {
		Child c = new Child();
		c.met();
	}
	
}

class Child extends Protected{
	
	public void met()
	{
		int x = n+5;
		System.out.println(x);
	}
}