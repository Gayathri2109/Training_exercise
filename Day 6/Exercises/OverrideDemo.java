package Exercises;

public class OverrideDemo {

	public static void main(String[] args) {
		Parent p = new Child();
		p.met();
	}
}

abstract class Parent
{
	final int i =10;
	
	final public void met()
	{
		System.out.println("Parent method......");
	}
	public Parent() {
		// TODO Auto-generated constructor stub
		System.out.println("Parent Constructor created...");
	}
	
	public Parent(int i) {
		// TODO Auto-generated constructor stub
		System.out.println("Parent Parameterized Constructor created...");
	}
}

class Child extends Parent
{

	public Child() {
		// TODO Auto-generated constructor stub
		super(12);
		System.out.println("Child Constructor created...");
	}
	
}