package Day9.FridayFun;

public class Q50 {
public static void main(String[] args) {
	lightBlue b = new lightBlue();
	
}
}

class Colour{
	public Colour() {
		System.out.println("Superclass....");
	}
}

class lightColour extends Colour{

	public lightColour() {
		System.out.println("middle class....");
	}
}

class lightBlue extends lightColour{
	public lightBlue() {
		System.out.println("sub class..........");
	}
}