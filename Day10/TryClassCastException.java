package Day10;

import java.util.Scanner;

public class TryClassCastException {
public static void main(String[] args) {
	
	Stanley obj = new Stanley();
	Scanner scan = new Scanner(System.in);
	System.out.println("I am waiting...");
	String str = scan.next();
	Doctor1 doc = (Doctor1)obj;
	doc.doCure();
}
}



interface Doctor1{
	public void doCure();
}

class Stanley implements Doctor1 {
	@Override
	public void doCure() {
		System.out.println("Alopathy doctor....");
		
	}
	
}
