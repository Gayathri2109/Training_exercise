package Day9.FridayFun;

public class Q51 {
public static void main(String[] args) {
	Parent p1 = new Parent();
	System.out.println(p1.method());
	Parent p = new child();
	System.out.println(p.method());
}
}

class Parent{
	public int method()
	{
		return 5;
	}
}

class child extends Parent{
	public int method()
	{

		return 15;
	}
}