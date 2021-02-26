package Day8Interface;

public class Q4 {

	public static void catchInterface(i1 obj)
	{
		obj.met1();
		obj.met2();
	}
	
	public static void main(String[] args) {
	Q4.catchInterface(new i1() {
		
		@Override
		public void met2() {
			// TODO Auto-generated method stub
			System.out.println("Method 1 of interface i1...");
			
		}
		
		@Override
		public void met1() {
			// TODO Auto-generated method stub
			System.out.println("Method 2 of interface i1...");
			
		}
	});
	
	
}
}


interface i1{
	public void met1();
	public void met2();
	
}
interface i2{
	public void met1();
	public void met2();
	
}
interface i3{
	public void met1();
	public void met2();
}

interface newinetrface extends i1,i2,i3{

	public void method();
}

class Sample implements newinetrface{
	@Override
	public void met1() {
		System.out.println("Method 1 of interface i1...");
		
	}
	@Override
	public void met2() {
		System.out.println("Method 2 of interface i1...");
		
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
}