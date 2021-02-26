package Day8Interface;

import Day8.InterfaceQ5;

public class Q5 implements InterfaceQ5  {

	@Override
	public void met1() {
		System.out.println("Method 1...");
		
	}

	@Override
	public void met2() {
		System.out.println("Method 2...");
		
	}

	@Override
	public void met3() {
		System.out.println("Method 3...");
		
	}
	
	public static void main(String[] args) {
		Q5 q = new Q5();
		q.met1();
		q.met2();
		q.met3();
	}

}

