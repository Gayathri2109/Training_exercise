package Day9.FridayFun;

public class Q21 {
public static void main(String[] args) {
	boolean a = true, b = false,c,d,e,f,g;
	c = a | b;       
	d = a & b;
	e = a ^ b;
	f = (! a & b) | (a &! b);
	g =! a;
	
	System.out.println("c= "+c+"\nD= "+d+"\nE= "+e+"\nF= "+f+"\nG= "+g);
}
}
