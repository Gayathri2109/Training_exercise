package Day9.FridayFun;

public class Q24 {
public static void main(String[] args) {
	Perimeter p = new Perimeter();
	p.RectangleArea();
	p.RectanglePeri();
	p.SquareArea();
	p.SquarePeri();
}
}

class Area{
	int len = 5;
	int bre = 5;
	int sq = 10;
	
	public void RectangleArea()
	{
		System.out.println("Area of a rectangle: "+ len*bre);
	}
	
	public void SquareArea() {
		System.out.println("Area of a Square: "+sq*sq);
	}
}

class Perimeter extends Area{
	
	public void RectanglePeri()
	{
		int s = 2 *(len+bre);
		System.out.println("Perimeter of a rectangle: "+s);
	}
	
	public void SquarePeri()
	{
		System.out.println("Perimeter of a square: "+ 4*sq);
	}
	
}
