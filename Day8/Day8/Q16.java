package Day8;

public class Q16 {
	public static void main(String [] args)
	{ 
	X x1 = new X();
	Y y1 = new Y();
	
	
	X x2 = new Y();
	x2.do1();
	((Y) x2).do2();
	
	} 
}
class X 
{
	void do1() {
		
	} 
}
class Y extends X { 
	void do2() 
	{
		
	} 
}
