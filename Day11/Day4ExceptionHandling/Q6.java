package Day11.Day4ExceptionHandling;

import java.io.IOException;

//Derived class constructors cannot catch the exceptions of the base class constructor.....

public class Q6 {
	public static void main(String[] args) throws Exception {
		derived d = new derived();
	}
}


class Base{
	public Base() throws Exception{
		   throw new Custom1("Exception thrown...");
	    }
}

class derived extends Base{
	
	public derived() throws Exception{
		try {
			Base b = new Base();
		}
	 
		catch(Exception e){
		System.out.println("Exception caught by the derived class");
	       }
	}
}

class Custom1 extends IOException{
	String str;
	public Custom1(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		return this.str;
	}
}
