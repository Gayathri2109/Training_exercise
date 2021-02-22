package LabExercises;

public class AbstractClass {
public static void main(String[] args) {
	//Pepsi p = new Pepsi();
	Kalimark k = new Kalimark();
	//p.makePepsiCola();
	k.makeKalimarkCola();
}
}

abstract class Cola{
	public abstract void makeCola();
}


class Pepsi
{
	public void makePepsiCola()
	{
		//Cola cola = new Kalimark().new CampCola();
		//Cola cola = new Kalimark().getCola();
		//cola.makeCola();
		System.out.println("Cola made by pepsi with help of Campcola");
	}
}

class Kalimark
{
	int money = 100;
	public void makeKalimarkCola()
	{
		Cola obj = new Cola() {
			
			@Override
			public void makeCola() {
				// TODO Auto-generated method stub
				System.out.println("No more Campcola....it belongs to Kaliamrk");
			}
		};
		obj.makeCola();
	}
//	public void makeKalimarkCola()
//	{
//		//Local inner class
//		class CampCola extends Cola
//		{
//			int price = 1000;
//			public void makeCola()
//			{
//				System.out.println("Cola made by CampCola....."+ money);
//			}
//		}
//		
//		Cola cola = new CampCola();
//		cola.makeCola();
//		System.out.println("Cola made by Kalimark with help of Campcola"+ new CampCola().price);
//	}
	//inner class
//	private class CampCola extends Cola
//	{
//		int price = 1000;
//		public void makeCola()
//		{
//			System.out.println("Cola made by CampCola....."+ money);
//		}
//	}
//	
//	public Cola getCola()
//	{
//		return new CampCola();
//	}

	
}
