package Day8;

public class Q15 {
public static void main(String[] args) {
	House home = new House();
	System.out.println("Total Cost of the door area and the window area is  : "+home.costOfHouse());
}
}

class House{

	//in sq feet
	int doorArea = 200;
	int windowArea = 500;
	
	Door door = new Door(doorArea);
	Window win = new Window(windowArea);
	
	public int costOfHouse()
	{
		return door.doorCost()+win.windowCost();
	}
	
	
}

class Door{
	
	int price = 80; //per sq feet
	int doorArea;
	public Door(int i) {
		doorArea = i;
	}
	public int doorCost()
	{
		return price*doorArea;
	}
	
}

class Window{
	int price = 30; //in sq feet
	int windowArea;
	public Window(int i) {
		windowArea = i;
	}
	public int windowCost()
	{
		return price*windowArea;
	}
	
}
