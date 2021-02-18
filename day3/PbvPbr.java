package day3;

public class PbvPbr {
	public static void main(String[] args) {
		Laddu laddu = new Laddu();
		laddu.setsize(10);
		System.out.println("Initial value:"+laddu.getsize());
		Pbv lad1 = new Pbv();
		lad1.met(laddu.getsize());
		System.out.println("Pass by value:"+laddu.getsize());
		Pbr lad2 = new Pbr();
		lad2.met1(laddu);
		System.out.println("Pass by reference:"+laddu.getsize());
		
	}

}

class Pbv
{
	public void met(int size)
	{
		size = size - 5;
	}
	
}

class Pbr
{
	public void met1(Laddu laddu)
	{
		laddu.setsize(5);
	}
	
}

class Laddu{
	private int size;
	
	public void setsize(int size)
	{
		this.size = size;
	}
	
	public int getsize()
	{
		return size;
	}
	
}
