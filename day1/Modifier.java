package day1;

public class Modifier {

	public static void main(String[] args) {
		Method mem = new Method();
		//System.out.println(mem.i);
		System.out.println(mem.j);
		System.out.println(mem.k);
		System.out.println(mem.l);
	}
}

class Method{
	private 	int i=5;
	protected	int j=6;
	public 		int k=7;
				int l=8;
				
}