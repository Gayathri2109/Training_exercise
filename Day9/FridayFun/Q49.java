package Day9.FridayFun;

public class Q49 {
public static void main(String[] args) {
	Box b = new Box();
	b.Volume();
}
}

class Box{
	int height = 10;
	int length = 10;
	int breadth = 10;
	
	public void Volume()
	{
		System.out.println("Volume of the box: "+ height*breadth*length);
	}
}